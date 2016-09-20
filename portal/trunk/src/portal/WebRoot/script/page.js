/**
 * 分页js
 * 
 */

function nextPage() {
	goPage(parseInt(gn('page.currentPage').value) + 1);
}

function prevPage() {
	goPage(parseInt(gn('page.currentPage').value) - 1);
}

function firstPage() {
	goPage(1);
}

function lastPage() {
	goPage(parseInt(gn('page.totalPages').value));
}

function goPage(n) {
	var h = location.href;
	if (h.indexOf('pageSupport.currentPage=') != -1) {
		h = h.replace(/pageSupport.currentPage=\d+/, 'pageSupport.currentPage=' + n);
	} else {
		h += h.indexOf('?') == -1 ? '?' : '&';
		h += 'pageSupport.currentPage=' + n;
	}
	location.href = h;
}
		
