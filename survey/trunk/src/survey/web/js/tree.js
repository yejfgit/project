/**
 *	@Date 2010.03.16
 *	@required Prototype1.6
 */
if((typeof Prototype == 'undefined')||!(parseFloat(Prototype.Version)>=1.6))
	throw("document_JS library require Prototype library >= 1.6.0");
//索引
var MapIndex=Class.create(
	{
		initialize:function(){
			this.index={};
			this.indexPrefix="I_";
		},
		addIndex:function(id,obj){
			this.index[this.indexPrefix+id]=obj;
		},
		removeIndex:function(id){
			delete this.index[this.indexPrefix+id];
		},
		getIndexList:function(){
			var list=[];
			for(var property in this.index){
				list.push(this.index[property]);
			}
			return list;
		},
		getObject:function(id){
			return this.index[this.indexPrefix+id];
		}
	}
);

/**
 *	树对象
 */
var Tree=Class.create(
	{
		initialize:function(nodeList,options){//树初始化方法
			this.view;
			this.index=new MapIndex();
			this.compFunc;
			this.root=new Tree.Node(this,{TREE__ROOT__:true});
			this.unOrgNodes=new MapIndex();
			if(options){
				Object.extend(this,options);
			}
			if(this.compFunc==null&&this.NodeOptions&&this.NodeOptions.compFunc!=null)
				this.compFunc=this.NodeOptions.compFunc;
			this.appendNodeList(nodeList);
		},
		getAllNodes:function(){
			var nodes=this.index.getIndexList();
			if(this.compFunc){
				nodes.sort(this.compFunc);
			}
			return nodes;
		},
		getNode:function(id){//树中根据节点ID获取节点
			return this.index.getObject(id)||null;
		},
		getAllUnOrgNodes:function(){//获取所有未被组织的节点（已排序）
			var nodes=this.unOrgNodes.getIndexList();
			if(this.compFunc){
				nodes.sort(this.compFunc);
			}
			return nodes;
		},
		__appendToIndex:function(node){//添加到索引（私有方法）
			this.index.addIndex(node.id,node);
		},
		__removeFromIndex:function(node){//从索引移除（私有方法）
			this.index.removeIndex(node.id);
		},
		__orgNode:function(node){//组织节点（私有方法，索引未被组织的节点看是否存在该节点的子节点）
			this.unOrgNodes.getIndexList().each(
				function(item){
					if(node.id==item.getParentId()){
						node.appendChild(item);
						this.unOrgNodes.removeIndex(item.id);
					}
				},this);
			return node;
		},
		__addUnOrgNode:function(node){//添加未被组织的节点（私有方法）
			this.unOrgNodes.addIndex(node.id,node);
		},
		__removeUnOrgNode:function(node){//移除未被组织的节点（私有方法）
			this.unOrgNodes.removeIndex(node.id);
		},
		appendNodeList:function(nodeList){//添加节点列表
			if(Object.isArray(nodeList)){
				this.__beginAddNodes=true;
				nodeList.each(function(item,index){
					this.appendNode(item);
				},this);
				this.__beginAddNodes=false;
				//对于添加的节点集排序方法调用的优化处理，一个变更了字节点的节点只需要排序一次
				var sortList={};
				nodeList.each(function(item,index){
					if(!item)return;
					var node=this.getNode(item.id);
					if(!node)return;
					if(node.parent){
						if(!sortList[node.parent.id]){
							sortList[node.parent.id]=true;
							if(this.compFunc)
							node.parent.sortChilds(this.compFunc);
						}
					}
				},this);
			}else{alert("append node error!(line:111)");}
		},
		appendNode:function(node){//添加单个节点到树上，支持（更新，移动，新增）
			if(!node)
				return null;
			node=new Tree.Node(this,node);
			var oldNode=this.getNode(node.id);
			if(oldNode){
				if(oldNode.parent){
					oldNode.parent.deleteChild(oldNode);
				}
				for(var i=0,length=oldNode.child.length;i<length;i++){
					node.appendChild(oldNode.child[i]);
				}
				node.setViewContent(oldNode.viewContent);
				node.refresh=oldNode.refresh;
				node.levelChange=oldNode.leveChange;
			}else{
				this.__orgNode(node);
			}
			this.__removeUnOrgNode(node);
			this.__appendToIndex(node);
			var parent;
			if(node.getParentId()){
				parent=this.getNode(node.getParentId());
			}else{
				parent=this.root;
			}
			if(parent){
				parent.appendChild(node);
			}else{
				node.parent=null;
				this.__addUnOrgNode(node);
				node.setRootNode(false);
			}
			return node;
		},
		deleteNode:function(node,cascadeDelete){//从树中删除节点
			if(!node)
				return;
			if(!(node instanceof Tree.Node))
				node=new Tree.Node(this,node);
			node=this.getNode(node.id);
			var childs=node.child;
			for(var i=0,length=childs.length;i<length;i++){
				if(cascadeDelete){
					this.deleteNode(childs[i],cascadeDelete);
				}else{
					childs[i].parent=null;
					childs[i].setRootNode(false);
					this.__addUnOrgNode(childs[i]);
				}
			}
			this.__removeFromIndex(node);
			this.__removeUnOrgNode(node);
			if(node.parent)
				node.parent.deleteChild(node);
		},
		sort:function(){//排序
			if(!this.compFunc)
				return;
			this.root.sortChilds(this.compFunc);
			this.getAllNodes().each(function(node){
				if(node.isFolder())
					node.sortChilds(this.compFunc);
			},this);
		},
		setSort:function(compFunc){//设置排序器
			this.compFunc=compFunc;
			this.sort();
		}
	}
);
Tree.NodeTypes={//节点类型，用于区分不同节点
	typeCache:new MapIndex(),
	getType:function(nodeModelName){
		if(!nodeModelName)return null;
		var _clazz=Tree.NodeTypes.typeCache.getObject(nodeModelName);
		if(!_clazz){
			_clazz=Class.create({
				clone:function(){
					var object=new this.constructor();
					Object.extend(object,this);
					return object;
				}
			});
			Tree.NodeTypes.typeCache.addIndex(nodeModelName,_clazz);
		}
		return _clazz;
	}
}
Tree.Node=Class.create(//节点类
		{
			initialize:function(tree,node){//初始化方法
			if(!node)
				throw "parameter node is required";
			if(!tree||!(tree instanceof Tree))
				throw "property tree is required";
			if(tree.NodeOptions){
				Object.extend(this,tree.NodeOptions);
			}
			if(node instanceof Tree.Node){//复制数据
				if(node.tree!=tree){
					node=Object.extend({},node.properties);
				}
			}else{
				node=Object.extend({},node);
			}
			Object.extend(
					this,
					{
						tree:tree,
						root:null,
						id:node.id,
						properties:(node instanceof Tree.Node)?node.properties:node,
						parent:null,
						child:[],
						viewContent:null,
						refresh:false,//默认为未更新子数据，需要重新载入
						change:true,//用于显示
						levelChange:true//用于显示
					}
			)
			if(!this.properties.TREE__ROOT__){
				if(!this.id)
					throw "property id is required";
				if(this.getParentId()&&(this.getParentId()==this.id))
					throw "error node parent id";
				if(!this.properties.modelName){//区分节点类型
					this.properties.modelName="normalNode";
				}
				var _clazz=Tree.NodeTypes.getType(this.properties.modelName);
				if(this.properties instanceof _clazz){
					this.properties=this.properties.clone();
				}else{
					var _properties=new _clazz();
					Object.extend(_properties,this.properties);
					this.properties=_properties;
				}
			}else{
				this.root=this;
			}
		},
		isFolder:function(){
			if(this.child.length>0)
				return true;
			else return false;
		},
		getParentId:function(){
			return this.properties.parentId;
		},
		appendChild:function(node){//添加子节点（私有方法）
			if(!(node instanceof Tree.Node))
				throw "argument not support";
			node.parent=this;
			this.child.push(node);
			if((this.root||node.root)&&!(this.root&&node.root))
				node.setRootNode(this.root!=null);
			if(this.tree.compFunc){
				this.sortChilds(this.tree.compFunc);
			}
		},
		deleteChild:function(node){//删除子节点（私有方法）
			if(!(node instanceof Tree.Node))
				throw "argument not support";
			for(var i=0,length=this.child.length;i<length;i++){
				if(this.child[i].id==node.id){
					node=this.child[i];
					this.child.splice(i,1);
					break;
				}
			}
		},
		sortChilds:function(sortFunc){//排序子节点
			if(this.tree.__beginAddNodes||!sortFunc)return;
			try{
				this.child.sort(sortFunc);
			}catch(e){}
		},
		setRootNode:function(isSetted){//设置根（私有方法）
			for(var i=0,length=this.child.length;i<length;i++){
				this.child[i].setRootNode(isSetted);
			}
			this.root=isSetted?this.tree.root:null;
		},
		setViewContent:function(viewContent){//设置节点显示对象（私有方法）
			if(viewContent&&Object.isElement(viewContent)){
				this.viewContent=viewContent;
				viewContent.node=this;
			}else{
				if(this.viewContent)
					this.viewContent.node=null;
				this.viewContent=null;
			}
		},
		getViewContent:function(){
			return this.viewContent;
		},
		getChilds:function(isUnCloneObject){//返回子节点
			if(isUnCloneObject)
				return this.child;
			return this.child.clone();//返回子节点副本，避免外部修改
		},
		isRootNode:function(){//是否根节点
			return !!this.properties.TREE__ROOT__;
		},
		isOrgedNode:function(){//是否已加入树(组织)的节点
			return !!this.root;
		},
		isUnOrgNode:function(){//是否未被组织起来的节点
			return (!this.isOrgedNode())&&!this.parent;
		},
		isIsolateNode:function(){//是否孤立节点
			return this.isUnOrgNode()&&(this.getChilds(true).length==0);
		}
		}
)
//显示树
var TableTree={
	Tree:Tree,
	View:Class.create({
		initialize:function(option){
			//内部属性
			this.tree=option.tree;//树
			this.table=option.table;//table表
			this.cells=0;//列数
			this.rootNodes=[];//显示的根节点列表
			this.rootNodesHash={};//根节点
			this.__notContainTopId;//不包含顶层节点
			this.topId=null;//显示的顶层ID
			this.cellsHandles=[];
			this.status={};
			//显示设置
			this.isShowWhenParentNotFound=false;//是否显示孤立节点
			this.refreshAlways=false;//是否总是刷新数据
			//样式设置
			this.classNames=[];//间隔色定义
			this.specialStyleRuleFunc=this.classNameRule;//自定义显示效果函数
			this.showTreeRouteLine=false;//是否显示路径
			this.indentPixNumber=15;//每级缩进的像数宽度
			//选框设置
			this.hasCheckBox=false;//是否显示复选框
			//this.checkedEventHandle=this.defaultCheckedEventHandle;//复选事件(event,checkbox) 全选
			this.checkedEventHandle=this.nothingCheckedEventHandle;//不做处理
			this.checkBoxName="id";//复选框名称
			this.customCheckBoxNameFunc=null;//自定义复选框名称函数
			this.setCheckBox=function(node,checkbox){};//设置checkbox
			this.hasRadio=false;//是否显示单选框
			this.radioEventHandle=this.defaultRadioEventHandle;//单选事件(event,radio)
			this.radioName="id";//单选框名称
			this.customRadioNameFunc=null;//自定义单选框名称函数
			this.setRadio=function(node,radio){};//设置radio
			//子节点载入定义
			this.loadChildsUrl=null;//载入子节点URL
			this.customLoadChildsUrlFunc=null;//自定义载入子节点数据URL函数，返回URL或URL数组
			this.loadChildsUrlOptions={};//载入子节点扩展选项
			//事件通知
			this.statusChangeComplete=function(node){};//状态更改完成调用函数，根据用户需求扩展
			this.onCheckBoxSelect;//复选框选中通知
			this.onLineChanged;//行更改通知
			this.onLineCreate;//行生成通知
			this.onLineDelete;//行删除通知
			this.oLineHide;//行隐藏通知
			this.onLineShow;//行显示通知
			this.releaseEventFunc;//自定义卸载事件，防止内存泄漏 context:this,args:node;
			//内容定义
			this.onCustomCell=this.defaultCell;//自定义显示内容
			//内容定义（第二套内容定义，两者选其一设置）
			this.columnNames=[];//定义列元素
			this.getColumn=this.defaultGetColumn;//获取列内容
			this.getColumnPlaint=this.defaultGetColumnPlaint;//
			this.enableNodeProperty=true;//当列内容未找到时允许使用节点属性代替
			this.sortEnable=false;//允许排序
			this.alterSortEnable=false;//允许更换排序方式
			this.sortColumn=null;//排序列元素
			this.sortOrder="ASC";//排序方向
			this.alterColumnEnable=false;//允许更改列
			//
			this.OnGetImg=this.defaultGetImg;//@deprecated 图标
			this.onGetImg;//图标，用于替代OnGetImg函数，请主要设置该属性
			this.onCustomStatusTag=this.defaultStatusTag;//自定义状态标志
			this.ondblClickEventFunc=this.defaultOndblClickEventFunc;//自定义双击事件
			//this.onClickEventFunc=this.defaultOnClickEventFunc;//自定义单击事件
			/*
			 * 节点权限控制器
			 * node:需判断权限的节点
			 * 返回：allowed：true，denied：false
			 */
			this.nodePermissionController=function(node){
				return true;
			};
			/*
			 *载入子节点处理器
			 *this对象为当前的view对象
			 *node:需载入子节点的节点.
			 *completeHandle:子节点数据载入完成继续调用方法，参数:子节点返回节点列表 
			 *errorHandleL:子节点数据载入失败调用方法，参数:错误原因
			 */
			this.loadChildNodesHandle=function(node,completeHandle,errorHandle){
				node.__request={};//定义临时变量
				var options={//请求选项
						method:"post",
						parameters:"id="+node.id+"&text="+node.properties.text,
						onComplete:(function(__node,response){//处理响应
							var url=response.request.url;
							var text=response.responseText;
							if(Object.isString(text)&&text.isJSON()){//请求返回
								var list=text.evalJSON();
								if(Object.isArray(list)){//载入成功
									__node.__request[url].nodes=list;
									__node.__request[url].loaded=true;
									var allLoaded=true;
									var nodes=[];
									new Hash(__node.__request).each(function(item){
										var request=item.value;
										if(!request.loaded){
											allLoaded=false;
											throw $break;
										}
										nodes=nodes.concat(request.nodes);
									});
									if(allLoaded){//完全载入
										delete __node.__request;
										completeHandle(nodes);//完成处理
									}
								}else{//载入失败
									errorHandle("数据载入错误");
								}
							}else{
								errorHandle("数据载入错误");
							}
						}).bind(this,node)
					};
				Object.extend(options,this.loadChildsUrlOptions||{});//扩展选项
				var loadUrls=[];//构造请求列表
				var _loadChildsUrls=this.loadChildsUrl;
				if(this.customLoadChildsUrlFunc){
					_loadChildsUrls=this.customLoadChildsUrlFunc(node);
				}
				if(Object.isArray(_loadChildsUrls)){
					loadUrls=loadUrls.concat(_loadChildsUrls);
				}else{
					loadUrls.push(_loadChildsUrls);
				}
				loadUrls.each(function(url){
					node.__request[url]={};
				});
				loadUrls=loadUrls.compact();
				if(loadUrls.length==0){
					delete node.__request;
					completeHandle(node.getChilds());//完成处理
					return;
				}
				loadUrls.each(function(url){//发起请求
					new Ajax.Request(url,options);
				});
			};
			this.treeRootLineSources={
				x1:new Element("font").update("┕"),
				x2:new Element("font").update("┝"),
				x3:new Element("font").update("│"),
				x4:new Element("font").update("━"),
				blank:new Element("font").update("&nbsp;")
			};//图标
			Object.extend(this,option);
			this.__initialDisplay=false;//初始化显示
			if(this.table){
				this.cells=$(this.table.tHead).select("tr")[0].childElements().length;
				if(!this.table.tBodies||this.table.tBodies.length==0){
					$(this.table.tHead).insert({after:new Element("tbody")});
				}
			}
			if(this.hasCheckBox&&this.hasRadio)
				throw "can not have both checkbox and radio";
		},
		initHead:function(){//初始化表头，添加各种事件
			var act=function(e,index,action){
				var allHandles=this.cellsHandles[index];
				if(!allHandles)return;
				var handles=allHandles[action];
				if(!handles)return;
				for(var k=0,len=handles.length;k<len;k++){
					if(e.stopped)
						break;
					var handle=handles[k];
					handle.value(e);
				}
			};
			Event.observe(document,"mouseup",function(){
				var pointerCell=this.status.pointerCell;
				if(pointerCell){
					var oldPointerStyle=this.status.oldPointerStyle;
					pointerCell.setStyle({border:oldPointerStyle});
				}
				var changeCell=this.status.changeCell;
				if(changeCell){
					var oldChangeStyle=this.status.oldChangeStyle;
					changeCell.setStyle({border:oldChangeStyle});
				}
				this.status={};
			}.bind(this));
			this.__initHead=true;
			var index=0;
			if(this.hasCheckBox||this.hasRadio){
				index=1;
			}
			for(var i=0,len=this.cells-index;i<len;i++){
				var cell=this.table.tHead.rows[0].cells[i+index];
				cell.setStyle({cursor:"pointer"});
				cell.onmousedown=act.bindAsEventListener(this,i,"mousedown");
				cell.onmousemove=act.bindAsEventListener(this,i,"mousemove");
				cell.onmouseup=act.bindAsEventListener(this,i,"mouseup");
				this.cellsHandles[i]={"mousedown":[],"mouseup":[],"mousemove":[]};
				var columnName=this.columnNames[i];
				if(columnName){
					cell.column=columnName;
					if(this.alterColumnEnable){
						var name="alterColumn";
						var down=function(e){
							this.status.mouseDown= true;
							Event.stop(e);
						}.bind(this);
						var move=function(e){
							if(!this.status.mouseDown)return;
							var cell=Event.element(e);
							if(cell.tagName.toUpperCase()!="TD"){
								cell=cell.up("td");
							}
							this.status.mousemove= true;
							var pointerCell=this.status.pointerCell;
							if(!pointerCell){
								pointerCell=$(cell);
								var oldPointerStyle=pointerCell.getStyle("border")||"";
								this.status.oldPointerStyle=oldPointerStyle;
								pointerCell.setStyle({border:"2px dotted gray"});
								this.status.pointerCell=pointerCell;
							}
							if(cell!=pointerCell){
								var changeCell=this.status.changeCell;
								if(cell!=changeCell&&changeCell){
									var oldChangeStyle=this.status.oldChangeStyle;
									changeCell.setStyle({border:oldChangeStyle});
									changeCell=null;
								}
								if(!changeCell){
									changeCell=$(cell);
									this.status.oldChangeStyle=changeCell.getStyle("border")||"";
									changeCell.setStyle({border:"2px dotted red"});
									this.status.changeCell=changeCell;
								}
							}
							Event.stop(e);
						}.bind(this);
						var up=function(e){
							if(!this.status.mousemove)return;
							var cell=Event.element(e);
							if(cell.tagName.toUpperCase()!="TD"){
								cell=cell.up("td");
							}
							this.status.mouseDown= false;
							this.status.mousemove= false;
							var pointerCell=this.status.pointerCell;
							var changeCell=this.status.changeCell;
							if(changeCell){
								//交换元素内容
								var pinnerHTML=pointerCell.innerHTML;
								var cinnerHTML=changeCell.innerHTML;
								pointerCell.update(cinnerHTML);
								changeCell.update(pinnerHTML);
								//交换元素column属性
								var temp=pointerCell.column;
								pointerCell.column=changeCell.column;
								changeCell.column=temp;
								//交换column
								var pcolumn=pointerCell.column;
								var ccolumn=changeCell.column;
								var pi=this.columnNames.indexOf(pcolumn);
								var ci=this.columnNames.indexOf(ccolumn);
								this.columnNames[pi]=ccolumn;
								this.columnNames[ci]=pcolumn;
								//
								var oldChangeStyle=this.status.oldChangeStyle;
								changeCell.setStyle({border:oldChangeStyle});
								this.status.changeCell=null;
								this.status.pointerColumn=null;
								this.status.changeColumn=null;
								//this.clear();
								this.tree.getAllNodes().each(function(node){node.change=true;});
								this.refresh();
							}
							var oldPointerStyle=this.status.oldPointerStyle;
							pointerCell.setStyle({border:oldPointerStyle});
							this.status.pointerCell=null;
							Event.stop(e);
						}.bind(this);
						this.cellsHandles[i]["mousedown"].push({name:name,value:down});
						this.cellsHandles[i]["mousemove"].push({name:name,value:move});
						this.cellsHandles[i]["mouseup"].push({name:name,value:up});
					}
					if(this.alterSortEnable){
						var name="sortColumn";
						var handle=function(e){
							if(this.status.mouseMove)return;
							var cell=Event.element(e);
							if(cell.tagName.toUpperCase()!="TD"){
								cell=cell.up("td");
							}
							var column=cell.column;
							if(!column)
								return;
							var order=this.sortOrder=="ASC"?"DESC":"ASC";
							if(this.sortColumn!=column){
								order="ASC";
							}
							this.setSort(column, order);
						}.bind(this);
						this.cellsHandles[i]["mouseup"].push({name:name,value:handle});
					}
				}
			}
		},
		__appendNodeListFunc:function(node,list){//添加子节点并展开,私有方法
			node.refresh=true;
			node.getChilds(true).each(function(item,index){//清除不存在的节点
				for(var i=0;i<list.length;i++){
					if(!list[i])
						continue;
					if(list[i].id==item.id)//存在的节点数据
						return;
				}
				this.deleteNode(item);
			},this);
			this.tree.appendNodeList(list);
			list.each(function(item){
				if(!item)return;
				var node=this.tree.getNode(item.id);
				if(!this.nodePermissionController(node)){
					this.deleteNode(node);
				}
			},this);
			this.statusChange(null,node);
		},
		setClassNames:function(classNames){//设置显示样式
			if(Object.isArray(classNames)){
				this.classNames=classNames;
				this.stripe();
			}
		},
		setSpecialStyleRule:function(handle){//设置显示样式处理
			if(Object.isFunction(handle)){
				this.specialStyleRuleFunc=handle;
				this.stripe();
			}
		},
		stripe:function(){//处理显示效果
			if(!this.table)
				return;
			var trs=$(this.table.tBodies[0]).childElements()||[];
			trs.each(styleRule,{index:0,context:this});
			function styleRule(item){
				if(!Object.isElement(item)||!item.visible())
					return;
				this.context.specialStyleRuleFunc.apply(this.context,[item,this.index]);
				this.index++;
			}
		},
		classNameRule:function(item,index){//样式规则
			var targetClassName=this.classNames[index%this.classNames.length];
			this.classNames.each(function(name){
				if(name==targetClassName)
					this.addClassName(name);
				else
					this.removeClassName(name);
			},item);
		},
		setSort:function(column,order){//设置排序
			if(!this.sortEnable)
				return;
			this.sortColumn=column;
			this.sortOrder=order.toUpperCase();
			var sortFunc=function(node1,node2){
				if(node1.isFolder()^node2.isFolder())
					return node1.isFolder()?-1:1;
				var p1=this.getColumnPlaint(node1, this.sortColumn);
				var p2=this.getColumnPlaint(node2, this.sortColumn);
				var result=p1<p2;
				if(this.sortOrder=="DESC")
					result=!result;
				return result?-1:1;
			}.bind(this);
			this.tree.setSort(sortFunc);
			if(this.__initialDisplay){
				this.refresh();
			}
		},
		defaultGetColumnPlaint:function(node,column){
			var text="";
			var obj=this.getColumnContents(node, column, null);
			if(Object.isArray(obj)){
				for(var i=0,len=obj.length;i<len;i++){
					var e=obj[i];
					if(Object.isElement(e))
						text+=e.innerHTML;
					else
						text+=obj[i].toString();
				}
			}else if(Object.isElement(obj))
				text+=obj.innerHTML;
			else
				text=obj.toString();
			return text;
		},
		sortRootList:function(){//排列树根
			if(!this.table)
				return;
			this.rootNodes=[];
			this.rootNodesHash={};
			var nodeList=[];
			if(this.topId&&Object.isString(this.topId)&&!this.topId.blank()){
				var node=this.tree.getNode(this.topId);
				if(!node)
					return;
				var nodes;
				if(this.__notContainTopId){
					nodes=node.getChilds();
				}else{
					nodes=[node];
				}
				if(this.isShowWhenParentNotFound){
					var unOrgNodes=this.tree.getAllUnOrgNodes();
					nodes.each(function(_node){
						if(unOrgNodes.indexOf(_node)<0){
							unOrgNodes.shift(_node);
						}
					});
					nodeList=unOrgNodes;
				}else{
					nodeList=nodes;
				}
			}else{
				nodeList=this.tree.root.getChilds();
				if(this.isShowWhenParentNotFound){
					var unOrgNodes=this.tree.getAllUnOrgNodes();
					nodeList=nodeList.concat(unOrgNodes);
				}
			}
			this.rootNodes=nodeList.findAll(function(node){
				if(!this.nodePermissionController(node)){
					this.deleteNode(node);
					return false;
				}
				return true;
			},this);
			this.rootNodes.each(function(item){this.rootNodesHash[item.id]=item},this);
		},
		clear:function(){//清理树
			var nodes=this.tree.getAllNodes(true);
			for(var i=0,len=nodes.length;i<len;i++){
				this.clearNode(nodes[i]);
			}
		},
		clearNode:function(node){//清理节点
			var line=node.getViewContent();
			if(line){
				try{//卸载事件，防止内存泄漏
					if(this.releaseEventFunc){
						this.releaseEventFunc(node);
					}
					line.onclick=null;
					line.indexCell.onclick=null;line.indexCell=null;
					if(line.checkBox){
						line.checkBox.onclick=null;line.checkBox=null;
					}
					if(line.radio){
						line.radio.onclick=null;line.radio=null;
					}
					node.setViewContent(null);
					if(line.parentNode){
						line.remove();
					}
				}catch(e){}
			}
		},
		displayAll:function(topId,notContainTopId){//显示所有
			this.display(topId,notContainTopId);
			this.rootNodes.each(function(node){
				expand.bind(this)(node);
			},this);
			function expand(node){
				if(node.refresh){
					if(TableTree.TreeNodeStatus.collapse==node.getViewContent().status){
						this.statusChange.bind(this,null,node)();
						node.getChilds(true).each(expand,this);
					}
				}
			}
		},
		generatorAll:function(){//生成所有行
			this.rootNodes.each(function(node){
				genLine.bind(this)(node,0);
			},this);
			function genLine(node,level){
				if(!node.getViewContent()){
					node.setViewContent(this.generatorLine.bind(this)(node,level));
				}
				node.getChilds(true).each(function(child){genLine.bind(this)(child,level+1)},this);
			}
		},
		display:function(topId,notContainTopId){//显示树
			if(!this.tree||!this.table)
				return;
			if(this.__initialDisplay){
				this.clear();
			}
			if(!this.__initHead){
				this.initHead();
			}
			this.topId=topId;
			this.__notContainTopId=notContainTopId;
			this.sortRootList();
			//清空table
			$(this.table.tBodies[0]).childElements().each(function(line){line.remove();delete line.node.viewContent});
			//显示
			var template=document.createDocumentFragment();
			this.rootNodes.eachSlice(30,function(arrays,index){
				arrays.each(function(item,index){
					template.appendChild(this.generatorLine(item,0));
					this.showLine(item.getViewContent());
				},this);
				this.table.tBodies[0].appendChild(template);
			},this);
			this.stripe();
			this.__initialDisplay=true;
		},
		generatorLine:function(node,level){//生成行(私有方法)
			level=level||0;
			var line=node.getViewContent();
			var startCellNum=0;
			if(!line){
				node.change=true;
				line=new Element("tr");
				node.setViewContent(line);
				if(this.hasCheckBox){//复选框
					startCellNum++;
					var cName=this.customCheckBoxNameFunc?this.customCheckBoxNameFunc(node):this.checkBoxName;
					var checkBox=new Element("input",{type:"checkBox",value:node.id,name:cName});
					var parentNode=node.parent;
					if(parentNode&&!parentNode.isRootNode()&&parentNode.getViewContent()){
						checkBox.checked=parentNode.getViewContent().checkBox.checked;
					}
					line.insert({top:new Element("td",{align:"center"}).update(checkBox)});
					if(line.checkBox){
						line.checkBox.onclick=null;line.checkBox=null;
					}
					line.checkBox=checkBox;//绑定关系
					checkBox.onclick=this.checkedEventHandle.bindAsEventListener(this);
					this.setCheckBox(node,checkBox);
				}
				if(this.hasRadio){//单选框
					startCellNum++;
					var rName=this.customRadioNameFunc?this.customRadioNameFunc(node):this.radioName;
					var radio=node.isFolder()?"":new Element("input",{type:"radio",value:node.id,name:rName});
					line.insert({top:new Element("td",{align:"center"}).update(radio)});
					if(line.radio){
						line.radio.onclick=null;line.radio=null;
					}
					line.radio=radio;//绑定关系
					radio.onclick=this.radioEventHandle.bindAsEventListener(this);
					this.setRadio(node,radio);
				}
				for(var i=startCellNum;i<this.cells;i++){
					var td=new Element("td");
					if(!line.indexCell){
						var div=new Element("div");
						td.update(div);
						line.indexCell=div;
					}
					line.insert(td);
				}
				line.status=TableTree.TreeNodeStatus.collapse;
			}
			line.level=level;
			if(node.change){
				line.childElements().each(function(item,index){
					if(index<startCellNum)return;
					if(index==startCellNum)
						this.onCustomCell(node,line.indexCell,index,level);
					else
						this.onCustomCell(node,item,index,level);
					//if(item.innerHTML.blank())item.update("&nbsp;")
				},this);//更新数据
			}
			//处理缩进列
			var indent=line.indexCell;
			//生成图标
			var imgTag;
			if(this.onGetImg)
				imgTag=this.onGetImg(node,line.level);
			else
				imgTag=this.OnGetImg(node,line.level);
			if(line.imgTag&&line.imgTag.parentNode)
				line.imgTag.replace(imgTag);
			line.imgTag=imgTag;
			indent.insert({top:imgTag});

			//生成状态标志
			if(node.isFolder()){
				var statusTag=this.onCustomStatusTag(line.status,node)||new Element("a");
				if(line.statusTag){//防止内存泄漏
					line.statusTag.onclick=null;line.statusTag.line=null;
				}
				if(line.statusTag&&line.statusTag.parentNode)
					line.statusTag.reaplace(statusTag);
				line.statusTag=statusTag;
				indent.insert({top:statusTag});
				this.addStatusTagEvent(line, statusTag);
			}
			//加入双击事件
			this.addDblClickEvent(line);
			//加入单击事件
			//this.addClickEvent(line);
			
			//生成缩进结构
			if(!this.showTreeRouteLine){
				indent.setStyle({paddingLeft:level*this.indentPixNumber+"px"});
			}else{
				//此处用于生成树形结构图，目前不完善
				var _node=node;
				for(var j=0;j<level;j++){
					var childs=_node.parent.getChilds(true);
					var _index=childs.indexOf(_node);
					if(j==0){
						if(_index==(childs.length-1)){
							indent.insert({top:this.treeRootLineSources.x1.cloneNode(true)});
						}else{
							indent.insert({top:this.treeRootLineSources.x2.cloneNode(true)});
						}
					}else{
						if(_index==(childs.length-1)){
							indent.insert({top:this.treeRootLineSources.blank.cloneNode(true)});
						}else{
							indent.insert({top:this.treeRootLineSources.x3.cloneNode(true)});
						}
					}
					_node=_node.parent;
				}
				indent.setStyle({paddingLeft:level*this.indentPixNumber+"px"});
			}
			node.change=false;//更新数据
			if(node.levelChange){
				node.levelChange=false;//更新行
				node.getChilds(true).each(function(item){item.levelChange=true});//子节点行变换
			}
			if(this.onLineChanged)
				this.onLineChanged(node,line);
			return line;
		},
		addStatusTagEvent:function(line,statusTag){//添加状态图标事件
			if(statusTag&&line){
				statusTag.setStyle({cursor:"pointer"});
				line.statusTag=statusTag;//绑定
				statusTag.line=line;
				line.indexCell.setStyle({cursor:"pointer"});
				line.indexCell.onclick=this.statusChange.bind(this,null,line.node);
				//line.indexCell.ondblclick=this.ondblClickEventFunc.bind(this,line.node);
			}
		},
		addDblClickEvent:function(line){//添加双击事件
			if(line){
				line.indexCell.setStyle({cursor:"pointer"});
				line.indexCell.ondblclick=this.ondblClickEventFunc.bind(this,line.node);
			}
		},
		
		//addClickEvent:function(line){//添加单击事件
		//	if(line){
		//		line.indexCell.setStyle({cursor:"pointer"});
		//		line.indexCell.onclick=this.onClickEventFunc.bind(this,line.node);
		//	}
		//},
		
		defaultStatusTag:function(status,node){//设置状态标志
			if(!node.isFolder())
				return;
			var statusTag;
			switch(status){
				case TableTree.TreeNodeStatus.collapse:{
					statusTag=new Element("font").setStyle({fontWeight:"bold",color:"#000000"}).update("+");
					break;
				}
				case TableTree.TreeNodeStatus.expanding:{
					statusTag=new Element("font").setStyle({fontWeight:"bold",color:"#000000"}).update(".");
					break;
				}
				case TableTree.TreeNodeStatus.expanded:{
					statusTag=new Element("font").setStyle({fontWeight:"bold",color:"#000000"}).update("-");
					break;
				}
			}
			return statusTag;
		},
		
		defaultOndblClickEventFunc:function(node){//默认双击事件
		// do nothing
		},
		
		//defaultOnClickEventFunc:function(node){//默认单击事件
		// do nothing
		//},
		
		setRefreshed:function(){//所有节点都已更新，勿需刷新数据
			this.tree.getAllNodes().each(function(node){
				if(node.getChilds(true).length>0)
					node.refresh=true;
			},this);
		},
		statusChange:function(event,node){//状态变更
			if(event){
				event=Event.extend(event);
				event.stop();
			}
			var line;
			if(node)
				line=node.getViewContent();
			else{
				line=event.element();
				while(line.tagName.toLowerCase()!="tr"){
					line=line.up("tr");
				}
				node=line.node;
			}
			var status=line.status;
			switch(status){
				case TableTree.TreeNodeStatus.collapse:{//收缩状态
					if(node.isFolder()){//允许展开
						if(this.refreshAlways||!node.refresh){//是否刷新
							line.status=TableTree.TreeNodeStatus.expanding;
							var completeHandle=this.__appendNodeListFunc.bind(this,node);
							var errorHandle=function(){};
							try{//载入数据
								this.loadChildNodesHandle(node,completeHandle,errorHandle);
							}catch(e){}
						}else{
							line.status=TableTree.TreeNodeStatus.expanded;
							this.showLine(line);
						}
					}
					break;
				}
				case TableTree.TreeNodeStatus.expanding:{//正在展开状态
					line.status=TableTree.TreeNodeStatus.expanded;
					this.showLine(line);
					break;
				}
				case TableTree.TreeNodeStatus.expanded:{//展开状态
					line.status=TableTree.TreeNodeStatus.collapse;
					line.node.getChilds(true).each(function(item){if(item.getViewContent()){this.hideLine(item.getViewContent())}},this);
					break;
				}
			}
			//以下三行在数据库中无是否叶子节点字段时使用
			if(node.refresh&&!node.getChilds(true).length>0)
				var newStatusTag = new Element("img",{src:"images/file.gif"})
			else
				var newStatusTag=this.onCustomStatusTag(line.status,node)||new Element("a");//更新图标
			line.statusTag.replace(newStatusTag);//无需判断是否有状态图标，因为有状态图标的行才允许状态变换
			this.addStatusTagEvent(line, newStatusTag);
			this.stripe();
			if(line.status!=TableTree.TreeNodeStatus.expanding){
				if(this.statusChangeComplete)
					this.statusChangeComplete(node);
			}
		},
		hideLine:function(line){//隐藏行
			if(!line)return;
			if(line.status!=TableTree.TreeNodeStatus.collapse){
				var node=line.node;
				node.getChilds(true).each(function(item){if(item.getViewContent()){this.hideLine(item.getViewContent())}},this);
			}
			line.hide();
		},
		showLine:function(line,checkChilds){//显示行
			if(line.node.change||line.node.levelChange){//更新显示
				line=this.generatorLine(line.node,line.level);
			}
			line.show();
			if(line.statusTag&&line.status==TableTree.TreeNodeStatus.expanded){//递归子层显示
				var allLines=this.table.tBodies[0].rows;
				var node=line.node;
				var childs=node.getChilds(true);
				var level=line.level+1;
				childs.each(function(item,index){
					if(item.getViewContent()){//存在行
						var oldLevel=item.getViewContent().level;//原始行缩进级别
						item.getViewContent().level=level;
						if(oldLevel!=level){//行缩进级别变换
							item.levelChange=true;
						}
					}else{//不存在
						item.levelChange=true;//行缩进级别变换
						var newLine=this.generatorLine(item,level);//生成新行
						item.setViewContent(newLine);
					}
					var thisLine=item.getViewContent();
					if(index==0){//确定插入位置（父节点后）
						//var fl=line.next("tr");
						var fl=line.nextSibling;
						if(fl!=thisLine){
							line.insert({after:thisLine});
						}
					}
					else{//确定插入位置
						var beforeLine=childs[index-1].getViewContent();
						var beforeIndex=(function(array,value){
							for(var i=array.length-1;i>0;i--){
								if(value==array[i])return i;
							}
							return -1;
						})(allLines,beforeLine);
						var thisPosition=allLines[++beforeIndex];
						while(thisPosition&&thisPosition.level>beforeLine.level){
							thisPosition=allLines[++beforeIndex];
						};
						if(thisPosition){//（下一节点前）
							if(thisPosition!=thisLine){
								thisPosition.insert({before:thisLine});
							}
						}else{//结尾
							$(this.table.tBodies[0]).insert({bottom:thisLine});
						}
					}
					this.showLine(thisLine,checkChilds);
				},this);
				if(line.checkBox&&line.checkBox.notPassToChild){//复选事件传递
					var checked=line.checkBox.checked;
					childs.each(function(item){
						this.checkedEventHandle(null,line.checkBox,true);
					},this);
					line.checkBox.notPassToChild=false;
				}
			}else{
				if(checkChilds)
					line.node.getChilds(true).each(this.hideNode.bind(this));
			}
		},
		expandTo:function(node){//展开到指定节点
			if(node.getViewContent()&&node.getViewContent().visible())
				return true;
			if(node.isRootNode()||!node.isOrgedNode())
				return false;
			var parent=node.parent;
			if(!parent.getViewContent()||!parent.getViewContent().visible()){
				var success=this.expandTo(parent);
				if(!success)
					return false;
			}
			this.statusChange(null,node.parent);//展开父节点
			return true;
			
		},
		defaultGetImg:function(){},
		defaultCell:function(node,cell,index,level){//默认表格内容
			if(this.hasCheckBox||this.hasRadio)
				index--;
			var columnName=this.columnNames[index];
			if(!columnName){
				cell.update();
				return;
			}else{
				var contents=this.getColumnContents(node, columnName, level);
				if(Object.isArray(contents)){
					cell.update();
					for(var i=0,len=contents.length;i<len;i++){
						cell.insert(contents[i]);
					}
				}else{
					cell.update(contents);
				}
			}
		},
		getColumnContents:function(node, columnName, level){
			var contents=this.getColumn(node, columnName, level);
			if(!contents){
				contents=[];
				if(this.enableNodeProperty){
					var property=node.properties[columnName]||"";
					contents.push(property);
				}
			}
			return contents;
		},
		defaultGetColumn:function(node,column,level){//默认获取列内容函数
			return node.properties[column];
		},
		defaultCheckedEventHandle:function(event,element,parentPassHere){//默认复选事件
			var checkBox=element||Event.element(event);
			var checked=checkBox.checked;
			var node=this.tree.getNode(checkBox.value);
			checkBox.notPassToChild=true;
			if(node.getViewContent().status==TableTree.TreeNodeStatus.expanded){
				node.getChilds(true).each(function(_node,index){
					_node.getViewContent().checkBox.checked=checked;
					this.checkedEventHandle(event,_node.getViewContent().checkBox,true);
				},this);//传递事件到下一级
				checkBox.notPassToChild=false;
			}
			if(!parentPassHere){
				checkParent(node);
				if(this.onCheckBoxSelect){
					this.onCheckBoxSelect(node);
				}
			}
			function checkParent(node){
				var parentNode=node.parent;
				if(parentNode&&!parentNode.isRootNode()&&parentNode.getViewContent()){
					var pCheckBox=parentNode.getViewContent().checkBox;//父节点的选框
					var nodeCheckBox=node.getViewContent().checkBox;//本节点的选框
					var _pcheckedValue=pCheckBox.checked;//父节点之前的选择
					var _ncheckedValue=nodeCheckBox.checked;//子节点的选择
					if(_pcheckedValue==_ncheckedValue)return;
					pCheckBox.checked=_ncheckedValue;
					if(_ncheckedValue){
						parentNode.getChilds(true).each(function(_node){
							if(node==_node)return;
							var _subLine=_node.getViewContent();
							var _subValue=_subLine?_subLine.checkBox.checked:false;
							if(!_subValue){
								pCheckBox.checked=_subValue;
								throw $break;
							}
						});
					}
					if(_pcheckedValue!=pCheckBox.checked){
						checkParent(parentNode);
					}
				}
			}
		},
		nothingCheckedEventHandle:function(event,element,parentPassHere){//默认复选事件
			//do nothing
		},
		checkAll:function(checked){//全选/全不选
			if(!this.hasCheckBox)return;
			for(var i=0,len=this.rootNodes.length;i<len;i++){
				this.checkNode(this.rootNodes[i].id, checked);
			}
		},
		checkNode:function(id,checked){//选择节点
			if(!this.hasCheckBox&&!this.hasRadio)return;
			var node=this.tree.getNode(id);
			if(!node)return;
			if(!node.getViewContent()){//检测是否显示行
				//检查是否在显示节点的子节点的范围内
				var parent=node.parent;
				var permission=false;
				var level=1;
				while(parent&&!parent.isRootNode()){
					if(parent.getViewContent()){//如果父节点生成了行，则有权限生成行
						permission=true;
						break;
					}
					parent=parent.parent;
					level++;
				}
				if(!permission)return;
				node.setViewContent(this.generatorLine(node,parent.getViewContent().level+level));
			}
			if(this.hasCheckBox){
				var checkBox=node.getViewContent().checkBox;
				checkBox.checked=!!checked;
				this.checkedEventHandle(null,checkBox);
			}else{
				var radio=node.getViewContent().radio;
				radio.checked=!!checked;
				this.radioEventHandle(null,radio);
			}
		},
		getCheckedNodeIDs:function(filter){//获取所有选择节点的ID
			if(!this.hasCheckBox)
				return null;
			var nodes={};
			this.rootNodes.each(function(node){
				var nodeList=this.getCheckedNodesBySingleNode(node,filter);
				for(var i=nodeList.length-1;i>=0;i--){
					nodes[nodeList[i].id]=nodeList[i];
				}
			},this);
			return $H(nodes).keys();
			
		},
		getCheckedNodes:function(filter){//获取所有选择的节点
			if(!this.hasCheckBox)
				return null;
			var nodes={};
			this.rootNodes.each(function(node){
				var nodeList=this.getCheckedNodesBySingleNode(node,filter);
				for(var i=nodeList.length-1;i>=0;i--){
					nodes[nodeList[i].id]=nodeList[i];
				}
			},this);
			return $H(nodes).values();
			
		},
		getCheckedNodesBySingleNode:function(node,filter){//获取一节点和所有子节点中选择的节点
			var nodes={};
			if(node.getViewContent()){
				if(node.getViewContent().checkBox.checked){
					if(!filter||filter(node))
						nodes[node.id]=node;
				}
				if(node.isFolder()){//folder节点
					if(node.getViewContent().checkBox.notPassToChild){//未传递到子层去的事件
						if(node.getViewContent().checkBox.checked){//选中，添加所有子节点
							var nodeList=this.getAllChildNodes(node,filter);
							for(var i=nodeList.length-1;i>=0;i--){
								nodes[nodeList[i].id]=nodeList[i];
							}
						}else{//未选中，不做处理
							
						}
					}else{//已传递到子层去的事件，遍历下层元素节点获取选择的节点
						node.getChilds(true).each(function(_node){
							var nodeList=this.getCheckedNodesBySingleNode(_node,filter);
							for(var i=nodeList.length-1;i>=0;i--){
								nodes[nodeList[i].id]=nodeList[i];
							}
						},this);
					}
				}
			}
			return $H(nodes).values();
		},
		//获取选中的父节点
		getCheckedParentNodes:function(filter){
			if(!this.hasCheckBox)
				return null;
			var nodes={};
			this.rootNodes.each(function(node){
				var nodeList=this.getCheckedNode(node,filter);
				for(var i=nodeList.length-1;i>=0;i--){
					nodes[nodeList[i].id]=nodeList[i];
				}
			},this);
			return $H(nodes).values();
			
		},
		getCheckedNode:function(node,filter){//获取一节点和所有子节点中选择的节点
			var nodes={};
			if(node.getViewContent()){
				if(node.getViewContent().checkBox.checked){
					if(!filter||filter(node))
						nodes[node.id]=node;
				}
				if(node.isFolder()){//folder节点
//					if(node.getViewContent().checkBox.notPassToChild){//未传递到子层去的事件
						if(node.getViewContent().checkBox.checked){//选中，添加所有子节点
							//var nodeList=this.getAllChildNodes(node,filter);
							//for(var i=nodeList.length-1;i>=0;i--){
//							alert(node.id);
								nodes[node.id]=node;
							//}
						}else{//未选中，不做处理
							
//						}
//					}else{//已传递到子层去的事件，遍历下层元素节点获取选择的节点
						node.getChilds(true).each(function(_node){
							var nodeList=this.getCheckedNode(_node,filter);
							for(var i=nodeList.length-1;i>=0;i--){
								nodes[nodeList[i].id]=nodeList[i];
							}
						},this);
					}
				}
			}
			return $H(nodes).values();
		},
		
		getAllChildNodes:function(node,filter){//获取节点和所有子节点
			var nodes={};
			if(!filter||filter(node)){
				nodes[node.id]=node;
			}
			if(node.isFolder()){
				node.getChilds(true).each(function(_node){
					var nodeList=this.getAllChildNodes(_node,filter);
					for(var i=nodeList.length-1;i>=0;i--){
						nodes[nodeList[i].id]=nodeList[i];
					}
				},this);
			}
			return $H(nodes).values();
		},
		defaultRadioEventHandle:function(event,element){//默认单选事件
			//do nothing
		},
		updateNodes:function(list){//更新节点
			this.tree.appendNodeList(list);
			list.each(
				function(item,index){
					if(!item||!item.id)
						return;
					var node=this.tree.getNode(item.id);
					if(!node)
						return;
					node.change=true;
					if(node.parent&&node.parent.getViewContent()&&!node.parent.getViewContent().statusTag)//如果父节点由叶子节点变为枝节点，刷新显示父节点
						node.parent.change=true;
				},this);
			this.refresh();
		},
		sortLine:function(tbody,nodes,index,level){//排列顺序
			nodes.each(function(node){
				var line=node.getViewContent();
				if(!line){
					node.change=true;
					node.levelChange=true;
				}else if(line.level!=level){
					node.levelChange=true;
				}if(node.change||node.levelChange){
					line=this.generatorLine(node,level);
				}
				if(index==0){
					$(tbody).insert({top:line});
				}else{
					tbody.rows[index-1].insert({after:line});
				}
				index++;
				if(line.statusTag&&line.status==TableTree.TreeNodeStatus.expanded){
					index=this.sortLine(tbody,node.getChilds(true),index,level+1);
				}
			},this);
			return index;
		},
		refresh:function(){//刷新表
			//按顺序排列行
			this.sortRootList();//排序根节点
			//更新顺序
			this.sortLine(this.table.tBodies[0],this.rootNodes,0,0);
			//更新显示
			this.rootNodes.each(function(node,index){
				this.refreshNode(node);
			},this);
			//更新间隔色
			this.stripe();
		},
		refreshNode:function(node){//刷新节点
			var line=node.getViewContent();
			if(!line){
				this.hideNode(node);
			}else{
				if(line.visible()){//显示的,检测子节点
					this.showLine(line,true);
				}else{//隐藏的
					this.hideNode(node);
				}
			}
		},
		hideNode:function(node){//隐藏节点和所有子节点
			var line=node.getViewContent();
			if(line){
				line.status=TableTree.TreeNodeStatus.collapse;//置为收起
				this.hideLine(line);
				node.getChilds(true).each(this.hideNode.bind(this));
			}
		},
		deleteNodes:function(list){//删除节点列表
			list.each(
				function(item,index){
					if(!item||!item.id)
						return;
					var node=this.tree.getNode(item.id);
					if(!node)
						return;
					var parent=node.parent;
					this.deleteNode(node);
					if(parent&&!parent.isFolder()){//如果父节点不再是枝节点，刷新父节点显示
						parent.change=true;
						this.refreshNode(parent);
					}
				},this);
			this.stripe();
		},
		deleteNode:function(node){//删除节点(私有方法)
			node.getChilds().each(//删除子节点
				function(item){
					this.deleteNode(item);
				},this);
			this.clearNode(node);
			this.tree.deleteNode(node);
		}
	}),
	TreeNodeStatus:{//节点状态
		collapse:1,
		expanding:2,
		expanded:3,
		error:0
	},
	console:{
		debugable:false,
		out:[null],
		print:function(info){
			var date=new Date();
			this.out[this.out.length-1]=(this.out[this.out.length-1]||"")+
			date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+
			date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+","+date.getMilliseconds()
			+"  "+info;
		},
		println:function(info){
			this.print(info);
			this.out.push(null);
		},
		view:function(start,end){
			if(!start)start=0;
			if(!end)end=this.out.length;
			if(start>end){var temp=end;end=start;start=temp;}
			if(start<0)start=0;
			if(end>this.out.length)end=this.out.length;
			var _out=[];
			for(var i=start;i<end;i++){
				_out.push(this.out[i]);
			}
			if(typeof log !="undefined"){
				_out.each(log.debug);
			}else{
				alert(_out.join("\n"));				
			}
		},
		debug:function(info){
			if(this.debugable)
				this.println(info);
		}
	}
}
