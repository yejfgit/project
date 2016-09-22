package de.eclipsemagazin.mqtt.push;

public class MqttBroker {  
//    private static final int SEND_NUMBER = 5;  
//    static TopicConnection  connection;
//    static TopicSession session;/* 
//    public static void main(String[] args) throws JMSException { 
//        // ConnectionFactory ：连接工厂，JMS 用它创建连接  
//        ConnectionFactory connectionFactory;  
//        // Connection ：JMS 客户端到JMS Provider 的连接  
//        Connection connection = null;  
//        // Session： 一个发送或接收消息的线程  
//        Session session;  
//        // Destination ：消息的目的地;消息发送给谁.  ActiveMQConnectionFactory
//        Destination destination;  
//        // MessageProducer：消息发送者  
//        MessageProducer producer;  
//        // TextMessage message;  
//        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar  
//        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, tcp://192.168.0.183:61616);  
//        try {  
//            // 构造从工厂得到连接对象  
//            connection = connectionFactory.createConnection();  
//            // 启动  
//            connection.start();  
// 
//            // 获取操作连接  
//            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);  
//            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
//            destination = session.createQueue(FirstQueue);  
//            // 得到消息生成者【发送者】  
//            producer = session.createProducer(destination);  
//            // 设置不持久化，此处学习，实际根据项目决定  
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
//            // 构造消息，此处写死，项目就是参数，或者方法获取  
//            sendMessage(session, producer);  
//            session.commit();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            try {  
//                if (null != connection)  
//                    connection.close();  
//            } catch (Throwable ignore) {  
//            }  
//        } 
// 
//        init();
//        sendMessage(client123456,11111111111111111111111111111111); 
//    }
// 
// 
// 
// 
//    private static  void init() throws JMSException {
//        // 创建链接工厂
//                TopicConnectionFactory factory = new ActiveMQConnectionFactory(
//                        ActiveMQConnection.DEFAULT_USER,
//                        ActiveMQConnection.DEFAULT_PASSWORD, tcp://192.168.0.183:1883);
//                connection = factory.createTopicConnection();
//            // 启动连接
//            connection.start();
//        System.out.println(启动成功);
//            // 创建一个session会话 transacted
//        session = connection.createTopicSession(
//                Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//    }  
// 
// 
// 
// 
//    *//**
//     * 关闭connection和session
//     * 
//     * @throws Exception
//     *//*
//    private void close() throws Exception {
// 
//        // 关闭释放资源
//        if (session != null) {
//            session.close();
//            session = null;
//        }
//        if (connection != null) {
//            connection.close();
//            connection = null;
//        }
//        System.out.println(断开连接);
//    }
//    public static int sendMessage(  String DESTINATION,String message)throws Exception {  
//        for (int i = 1; i <= 1; i++) {  
//            TextMessage message = session.createTextMessage(ActiveMq 发送的消息 + i);  
//            // 发送消息到目的地方  
//            System.out.println(发送消息： + ActiveMq 发送的消息 + i);  
//            producer.send(message);  
//        }  
//        javax.jms.Topic topic;
//        try {
//            // 创建一个消息队列
//            topic = session.createTopic(DESTINATION);
//        } catch (Exception e) {
//            init();
//            topic = session.createTopic(DESTINATION);
//        }
// 
//        // 创建消息发送者
//javax.jms.TopicPublisher publisher =  session.createPublisher(topic);
// 
//        // 设置持久化模式
//        publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
// 
// 
// 
// 
// 
//        // flag=0,表示成功;flag=1,表示失败
//                int flag = 0;
// 
//                System.out.println(message);
//                TextMessage textMessage = session.createTextMessage(message);
// 
//                publisher.send(textMessage);
//                return flag;
//    }  */
// 
// 
//     private final static Log logger = LogFactory.getLog(MqttBroker.class);// 日志对象  
//        // 连接参数  
//        private final static String CONNECTION_STRING = tcp://192.168.0.183:1883;  
////      private final static String CONNECTION_STRING = tcp://192.168.0.183:1883;  
// 
//        private final static boolean CLEAN_START = true;  
//        private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s  
//        private final static String CLIENT_ID = master;// 客户端标识  
//        private final static int[] QOS_VALUES = { 0, 0, 2, 0 };// 对应主题的消息级别  
//        private final static String[] TOPICS = { Test/TestTopics/Topic1,  
//                Test/TestTopics/Topic2, Test/TestTopics/Topic3,  
//                client/keepalive };  
//        private static MqttBroker instance = new MqttBroker();  
// 
//        private MqttClient mqttClient;  
// 
//        /** 
//         * 返回实例对象 
//         *  
//         * @return 
//         */ 
//        public static MqttBroker getInstance() {  
//            return instance;  
//        }  
// 
//        /** 
//         * 重新连接服务 
//         */ 
//        private void connect() throws MqttException {  
//            logger.info(connect to mqtt broker.);  
//            System.out.println(connect to mqtt broker.);  
//            mqttClient = new MqttClient(CONNECTION_STRING);  
//            logger.info(***********register Simple Handler***********);  
//            System.out.println(***********register Simple Handler***********);  
//            SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();  
//            mqttClient.registerSimpleHandler(simpleCallbackHandler);// 注册接收消息方法  
//            mqttClient.connect(CLIENT_ID, CLEAN_START, KEEP_ALIVE);  
//            logger.info(***********subscribe receiver topics***********);  
//            System.out.println(***********subscribe receiver topics***********);  
//            mqttClient.subscribe(TOPICS, QOS_VALUES);// 订阅接主题  
// 
//            logger.info(***********CLIENT_ID: + CLIENT_ID);  
//            System.out.println(***********CLIENT_ID: + CLIENT_ID);  
//            /** 
//             * 完成订阅后，可以增加心跳，保持网络通畅，也可以发布自己的消息 
//             */ 
//            mqttClient.publish(keepalive, keepalive.getBytes(), QOS_VALUES[0],  
//                    true);// 增加心跳，保持网络通畅  
//        }  
// 
//        /** 
//         * 发送消息 
//         *  
//         * @param clientId   客户端主题 不是id
//         * @param messageId 
//         */ 
//        public void sendMessage(String clientId, String message) {  
//            try {  
//                if (mqttClient == null || !mqttClient.isConnected()) {  
//                    connect();  
//                }  
//                System.out.println(send message to  + clientId + , message is   
//                        + message);  
//                logger.info(send message to  + clientId + , message is   
//                        + message);  
//                // 发布自己的消息  
//                mqttClient.publish(clientId, message.getBytes(),  
//                        0, false);  
//                /*mqttClient.publish(GMCC/tokudu/ + clientId, message.getBytes(),  
//                        0, false); */
//              System.out.println(  ##################### + CLIENT_ID);  
//            } catch (MqttException e) {  
//                logger.error(e.getCause());  
//                e.printStackTrace();  
//            }  
//        }  
// 
//        /** 
//         * 简单回调函数，处理server接收到的主题消息 
//         *  
//         * @author Join 
//         *  
//         */ 
//        class SimpleCallbackHandler implements MqttSimpleCallback {  
// 
//            /** 
//             * 当客户机和broker意外断开时触发 可以再此处理重新订阅 
//             */ 
//            @Override 
//            public void connectionLost() throws Exception {  
//                // TODO Auto-generated method stub  
//                System.out.println(客户机和broker已经断开);  
//            }  
// 
//            /** 和broker已
//             * 客户端订阅消息后，该方法负责回调接收处理消息 
//             */ 
//            @Override 
//            public void publishArrived(String topicName, byte[] payload, int Qos,  
//                    boolean retained) throws Exception {  
//                // TODO Auto-generated method stub  
//                System.out.println(订阅主题:  + topicName);  
//                System.out.println(消息数据:  + new String(payload));  
//                System.out.println(消息级别(0,1,2):  + Qos);  
//                System.out.println(是否是实时发送的消息(false=实时，true=服务器上保留的最后消息):   
//                        + retained);  
//            }  
// 
//        }  
// 
//        public static void main(String[] args) {  
//            String ss={ itle: ghjklffff,content:aaaaaaaaaaaaaaaaaaa,    ype:1};
//            new MqttBroker().sendMessage(Fangchao,ss.replace(\, ));  
//        }  //一定要用tokudu/a06e51a5f424fb70 不要用tokudu.aasdf 用反斜杠  不要用点
    } 