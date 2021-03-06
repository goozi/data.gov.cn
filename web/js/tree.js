
var KTreeConfig = {
	rootIcon        : '/htc/images/foldericon.gif',
	openRootIcon    : '/htc/images/openfoldericon.gif',
	folderIcon      : '/htc/images/foldericon.gif',
	openFolderIcon  : '/htc/images/openfoldericon.gif',
	fileIcon        : '/htc/images/file.gif',
	iIcon           : '/htc/images/I.gif',
	lIcon           : '/htc/images/L.gif',
	lMinusIcon      : '/htc/images/Lminus.gif',
	lPlusIcon       : '/htc/images/Lplus.gif',
	tIcon           : '/htc/images/T.gif',
	tMinusIcon      : '/htc/images/Tminus.gif',
	tPlusIcon       : '/htc/images/Tplus.gif',
	blankIcon       : '/htc/images/blank.gif',
	defaultText     : 'Tree Item',
	defaultAction   : 'javascript:void(0);',
	defaultBehavior : 'classic',
	usePersistence	: false
};
var KTreeHandler = {
	idCounter : 0,
	idPrefix  : "webfx-tree-object-",
	all       : {},
	behavior  : null,
	selected  : null,
	onSelect  : null, /* should be part of tree, not handler */
	getId     : function() { return this.idPrefix + this.idCounter++; },
	toggle    : function (oItem) { this.all[oItem.id.replace('-plus','').replace('-anchor','').replace('-icon','')].toggle(); },
	select    : function (oItem) { this.all[oItem.id.replace('-icon','')].select(); },
	focus     : function (oItem) { this.all[oItem.id.replace('-anchor','')].focus(); },
	blur      : function (oItem) { this.all[oItem.id.replace('-anchor','')].blur(); },
	keydown   : function (oItem, e) { return this.all[oItem.id].keydown(e.keyCode); },
	cookies   : new KCookie(),
	insertHTMLBeforeEnd	:	function (oElement, sHTML) {
		if (oElement.insertAdjacentHTML != null) {
			oElement.insertAdjacentHTML("BeforeEnd", sHTML)
			return;
		}
		var df;	// DocumentFragment
		var r = oElement.ownerDocument.createRange();
		r.selectNodeContents(oElement);
		r.collapse(false);
		df = r.createContextualFragment(sHTML);
		oElement.appendChild(df);
	}
};

/*
 * KCookie class
 */

function KCookie() {
	if (document.cookie.length) { this.cookies = ' ' + document.cookie; }
}

KCookie.prototype.setCookie = function (key, value) {
	document.cookie = key + "=" + escape(value);
}

KCookie.prototype.getCookie = function (key) {
	if (this.cookies) {
		var start = this.cookies.indexOf(' ' + key + '=');
		if (start == -1) { return null; }
		var end = this.cookies.indexOf(";", start);
		if (end == -1) { end = this.cookies.length; }
		end -= start;
		var cookie = this.cookies.substr(start,end);
		return unescape(cookie.substr(cookie.indexOf('=') + 1, cookie.length - cookie.indexOf('=') + 1));
	}
	else { return null; }
}

/*
 * KTreeAbstractNode class
 */

function KTreeAbstractNode(sText, sAction) {
	this.childNodes  = [];
	this.id     = KTreeHandler.getId();
	this.text   = sText || KTreeConfig.defaultText;
	this.action = sAction || KTreeConfig.defaultAction;
	this._last  = false;
	KTreeHandler.all[this.id] = this;
}

/*
 * To speed thing up if you're adding multiple nodes at once (after load)
 * use the bNoIdent parameter to prevent automatic re-indentation and call
 * the obj.ident() method manually once all nodes has been added.
 */

KTreeAbstractNode.prototype.add = function (node, bNoIdent) {
	node.parentNode = this;
	this.childNodes[this.childNodes.length] = node;
	var root = this;
	if (this.childNodes.length >= 2) {
		this.childNodes[this.childNodes.length - 2]._last = false;
	}
	while (root.parentNode) { root = root.parentNode; }
	if (root.rendered) {
		if (this.childNodes.length >= 2) {
			document.getElementById(this.childNodes[this.childNodes.length - 2].id + '-plus').src = ((this.childNodes[this.childNodes.length -2].folder)?((this.childNodes[this.childNodes.length -2].open)?KTreeConfig.tMinusIcon:KTreeConfig.tPlusIcon):KTreeConfig.tIcon);
			this.childNodes[this.childNodes.length - 2].plusIcon = KTreeConfig.tPlusIcon;
			this.childNodes[this.childNodes.length - 2].minusIcon = KTreeConfig.tMinusIcon;
			this.childNodes[this.childNodes.length - 2]._last = false;
		}
		this._last = true;
		var foo = this;
		while (foo.parentNode) {
			for (var i = 0; i < foo.parentNode.childNodes.length; i++) {
				if (foo.id == foo.parentNode.childNodes[i].id) { break; }
			}
			if (i == foo.parentNode.childNodes.length - 1) { foo.parentNode._last = true; }
			else { foo.parentNode._last = false; }
			foo = foo.parentNode;
		}
		KTreeHandler.insertHTMLBeforeEnd(document.getElementById(this.id + '-cont'), node.toString());
		if ((!this.folder) && (!this.openIcon)) {
			this.icon = KTreeConfig.folderIcon;
			this.openIcon = KTreeConfig.openFolderIcon;
		}
		if (!this.folder) { this.folder = true; this.collapse(true); }
		if (!bNoIdent) { this.indent(); }
	}
	return node;
}

KTreeAbstractNode.prototype.toggle = function() {
	if (this.folder) {
		if (this.open) { this.collapse(); }
		else { this.expand(); }
}	}

KTreeAbstractNode.prototype.select = function() {
	document.getElementById(this.id + '-anchor').focus();
}

KTreeAbstractNode.prototype.deSelect = function() {
	document.getElementById(this.id + '-anchor').className = '';
	KTreeHandler.selected = null;
}

KTreeAbstractNode.prototype.focus = function() {
	if ((KTreeHandler.selected) && (KTreeHandler.selected != this)) { KTreeHandler.selected.deSelect(); }
	KTreeHandler.selected = this;
	if ((this.openIcon) && (KTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.openIcon; }
	document.getElementById(this.id + '-anchor').className = 'selected';
	document.getElementById(this.id + '-anchor').focus();
	if (KTreeHandler.onSelect) { KTreeHandler.onSelect(this); }
}

KTreeAbstractNode.prototype.blur = function() {
	if ((this.openIcon) && (KTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.icon; }
	document.getElementById(this.id + '-anchor').className = 'selected-inactive';
}

KTreeAbstractNode.prototype.doExpand = function() {
	if (KTreeHandler.behavior == 'classic') { document.getElementById(this.id + '-icon').src = this.openIcon; }
	if (this.childNodes.length) {  document.getElementById(this.id + '-cont').style.display = 'block'; }
	this.open = true;
	if (KTreeConfig.usePersistence) {
		KTreeHandler.cookies.setCookie(this.id.substr(18,this.id.length - 18), '1');
}	}

KTreeAbstractNode.prototype.doCollapse = function() {
	if (KTreeHandler.behavior == 'classic') { document.getElementById(this.id + '-icon').src = this.icon; }
	if (this.childNodes.length) { document.getElementById(this.id + '-cont').style.display = 'none'; }
	this.open = false;
	if (KTreeConfig.usePersistence) {
		KTreeHandler.cookies.setCookie(this.id.substr(18,this.id.length - 18), '0');
}	}

KTreeAbstractNode.prototype.expandAll = function() {
	this.expandChildren();
	if ((this.folder) && (!this.open)) { this.expand(); }
}

KTreeAbstractNode.prototype.expandChildren = function() {
	for (var i = 0; i < this.childNodes.length; i++) {
		this.childNodes[i].expandAll();
} }

KTreeAbstractNode.prototype.doExpandToLevel = function(i,level) {
	if (i>=level)
	{
		return;
	}	
	this.expandChildrenToLevel(i,level);
	if ((this.folder) && (!this.open)) { this.expand(); }
}

KTreeAbstractNode.prototype.expandChildrenToLevel = function(i,level) {
	var j=i+1;
	for (var i = 0; i < this.childNodes.length; i++) {
		this.childNodes[i].doExpandToLevel(j,level);
} }

KTreeAbstractNode.prototype.collapseAll = function() {
	this.collapseChildren();
	if ((this.folder) && (this.open)) { this.collapse(true); }
}

KTreeAbstractNode.prototype.collapseChildren = function() {
	for (var i = 0; i < this.childNodes.length; i++) {
		this.childNodes[i].collapseAll();
} }

KTreeAbstractNode.prototype.indent = function(lvl, del, last, level, nodesLeft) {
	/*
	 * Since we only want to modify items one level below ourself,
	 * and since the rightmost indentation position is occupied by
	 * the plus icon we set this to -2
	 */
	if (lvl == null) { lvl = -2; }
	var state = 0;
	for (var i = this.childNodes.length - 1; i >= 0 ; i--) {
		state = this.childNodes[i].indent(lvl + 1, del, last, level);
		if (state) { return; }
	}
	if (del) {
		if ((level >= this._level) && (document.getElementById(this.id + '-plus'))) {
			if (this.folder) {
				document.getElementById(this.id + '-plus').src = (this.open)?KTreeConfig.lMinusIcon:KTreeConfig.lPlusIcon;
				this.plusIcon = KTreeConfig.lPlusIcon;
				this.minusIcon = KTreeConfig.lMinusIcon;
			}
			else if (nodesLeft) { document.getElementById(this.id + '-plus').src = KTreeConfig.lIcon; }
			return 1;
	}	}
	var foo = document.getElementById(this.id + '-indent-' + lvl);
	if (foo) {
		if ((foo._last) || ((del) && (last))) { foo.src =  KTreeConfig.blankIcon; }
		else { foo.src =  KTreeConfig.iIcon; }
	}
	return 0;
}

/*
 * KTree class
 */

function KTree(sText, sAction, sBehavior, sIcon, sOpenIcon) {
	this.base = KTreeAbstractNode;
	this.base(sText, sAction);
	this.icon      = sIcon || KTreeConfig.rootIcon;
	this.openIcon  = sOpenIcon || KTreeConfig.openRootIcon;
	/* Defaults to open */
	if (KTreeConfig.usePersistence) {
		this.open  = (KTreeHandler.cookies.getCookie(this.id.substr(18,this.id.length - 18)) == '0')?false:true;
	} else { this.open  = true; }
	this.folder    = true;
	this.rendered  = false;
	this.onSelect  = null;
	if (!KTreeHandler.behavior) {  KTreeHandler.behavior = sBehavior || KTreeConfig.defaultBehavior; }
}

KTree.prototype = new KTreeAbstractNode;

KTree.prototype.setBehavior = function (sBehavior) {
	KTreeHandler.behavior =  sBehavior;
};

KTree.prototype.getBehavior = function (sBehavior) {
	return KTreeHandler.behavior;
};

KTree.prototype.getSelected = function() {
	if (KTreeHandler.selected) { return KTreeHandler.selected; }
	else { return null; }
}

KTree.prototype.remove = function() { }

KTree.prototype.expand = function() {
	this.doExpand();
}

KTree.prototype.expandToLevel = function(level)
{
	this.doExpandToLevel(0,level);
}

KTree.prototype.collapse = function(b) {
	if (!b) { this.focus(); }
	this.doCollapse();
}

KTree.prototype.getFirst = function() {
	return null;
}

KTree.prototype.getLast = function() {
	return null;
}

KTree.prototype.getNextSibling = function() {
	return null;
}

KTree.prototype.getPreviousSibling = function() {
	return null;
}

KTree.prototype.keydown = function(key) {
	if (key == 39) {
		if (!this.open) { this.expand(); }
		else if (this.childNodes.length) { this.childNodes[0].select(); }
		return false;
	}
	if (key == 37) { this.collapse(); return false; }
	if ((key == 40) && (this.open) && (this.childNodes.length)) { this.childNodes[0].select(); return false; }
	return true;
}

KTree.prototype.toString = function() {
	var str = "<div id=\"" + this.id + "\"  class=\"webfx-tree-item\" onkeydown=\"return KTreeHandler.keydown(this, event)\">" +
		"<img id=\"" + this.id + "-icon\" class=\"webfx-tree-icon\" src=\"" + ((KTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"KTreeHandler.toggle(this);\">" +
		"<a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\" onfocus=\"KTreeHandler.focus(this);\" onblur=\"KTreeHandler.blur(this);\"" +
		(this.target ? " target=\"" + this.target + "\"" : "") +
		">" + this.text + "</a></div>" +
		"<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
	var sb = [];
	for (var i = 0; i < this.childNodes.length; i++) {
		sb[i] = this.childNodes[i].toString(i, this.childNodes.length);
	}
	this.rendered = true;
	return str + sb.join("") + "</div>";
};

/*
 * KTreeItem class
 */

function KTreeItem(sText, sAction, eParent, sIcon, sOpenIcon) {
	this.base = KTreeAbstractNode;
	this.base(sText, sAction);
	/* Defaults to close */
	if (KTreeConfig.usePersistence) {
		this.open = (KTreeHandler.cookies.getCookie(this.id.substr(18,this.id.length - 18)) == '1')?true:false;
	} else { this.open = false; }
	if (sIcon) { this.icon = sIcon; }
	if (sOpenIcon) { this.openIcon = sOpenIcon; }
	if (eParent) { eParent.add(this); }
}

KTreeItem.prototype = new KTreeAbstractNode;

KTreeItem.prototype.remove = function() {
	var iconSrc = document.getElementById(this.id + '-plus').src;
	var parentNode = this.parentNode;
	var prevSibling = this.getPreviousSibling(true);
	var nextSibling = this.getNextSibling(true);
	var folder = this.parentNode.folder;
	var last = ((nextSibling) && (nextSibling.parentNode) && (nextSibling.parentNode.id == parentNode.id))?false:true;
	this.getPreviousSibling().focus();
	this._remove();
	if (parentNode.childNodes.length == 0) {
		document.getElementById(parentNode.id + '-cont').style.display = 'none';
		parentNode.doCollapse();
		parentNode.folder = false;
		parentNode.open = false;
	}
	if (!nextSibling || last) { parentNode.indent(null, true, last, this._level, parentNode.childNodes.length); }
	if ((prevSibling == parentNode) && !(parentNode.childNodes.length)) {
		prevSibling.folder = false;
		prevSibling.open = false;
		iconSrc = document.getElementById(prevSibling.id + '-plus').src;
		iconSrc = iconSrc.replace('minus', '').replace('plus', '');
		document.getElementById(prevSibling.id + '-plus').src = iconSrc;
		document.getElementById(prevSibling.id + '-icon').src = KTreeConfig.fileIcon;
	}
	if (document.getElementById(prevSibling.id + '-plus')) {
		if (parentNode == prevSibling.parentNode) {
			iconSrc = iconSrc.replace('minus', '').replace('plus', '');
			document.getElementById(prevSibling.id + '-plus').src = iconSrc;
}	}	}

KTreeItem.prototype._remove = function() {
	for (var i = this.childNodes.length - 1; i >= 0; i--) {
		this.childNodes[i]._remove();
 	}
	for (var i = 0; i < this.parentNode.childNodes.length; i++) {
		if (this == this.parentNode.childNodes[i]) {
			for (var j = i; j < this.parentNode.childNodes.length; j++) {
				this.parentNode.childNodes[j] = this.parentNode.childNodes[j+1];
			}
			this.parentNode.childNodes.length -= 1;
			if (i + 1 == this.parentNode.childNodes.length) { this.parentNode._last = true; }
			break;
	}	}
	KTreeHandler.all[this.id] = null;
	var tmp = document.getElementById(this.id);
	if (tmp) { tmp.parentNode.removeChild(tmp); }
	tmp = document.getElementById(this.id + '-cont');
	if (tmp) { tmp.parentNode.removeChild(tmp); }
}

KTreeItem.prototype.expand = function() {
	document.getElementById(this.id + '-plus').src = this.minusIcon;
	this.doExpand();
	
}

KTreeItem.prototype.collapse = function(b) {
	if (!b) { this.focus(); }
	document.getElementById(this.id + '-plus').src = this.plusIcon;
	this.doCollapse();
	
}

KTreeItem.prototype.getFirst = function() {
	return this.childNodes[0];
}

KTreeItem.prototype.getLast = function() {
	if (this.childNodes[this.childNodes.length - 1].open) { return this.childNodes[this.childNodes.length - 1].getLast(); }
	else { return this.childNodes[this.childNodes.length - 1]; }
}

KTreeItem.prototype.getNextSibling = function() {
	for (var i = 0; i < this.parentNode.childNodes.length; i++) {
		if (this == this.parentNode.childNodes[i]) { break; }
	}
	if (++i == this.parentNode.childNodes.length) { return this.parentNode.getNextSibling(); }
	else { return this.parentNode.childNodes[i]; }
}

KTreeItem.prototype.getPreviousSibling = function(b) {
	for (var i = 0; i < this.parentNode.childNodes.length; i++) {
		if (this == this.parentNode.childNodes[i]) { break; }
	}
	if (i == 0) { return this.parentNode; }
	else {
		if ((this.parentNode.childNodes[--i].open) || (b && this.parentNode.childNodes[i].folder)) { return this.parentNode.childNodes[i].getLast(); }
		else { return this.parentNode.childNodes[i]; }
} }

KTreeItem.prototype.keydown = function(key) {
	if ((key == 39) && (this.folder)) {
		if (!this.open) { this.expand(); }
		else { this.getFirst().select(); }
		return false;
	}
	else if (key == 37) {
		if (this.open) { this.collapse(); }
		else { this.parentNode.select(); }
		return false;
	}
	else if (key == 40) {
		if (this.open) { this.getFirst().select(); }
		else {
			var sib = this.getNextSibling();
			if (sib) { sib.select(); }
		}
		return false;
	}
	else if (key == 38) { this.getPreviousSibling().select(); return false; }
	return true;
}

KTreeItem.prototype.toString = function (nItem, nItemCount) {
	var foo = this.parentNode;
	var indent = '';
	if (nItem + 1 == nItemCount) { this.parentNode._last = true; }
	var i = 0;
	while (foo.parentNode) {
		foo = foo.parentNode;
		indent = "<img id=\"" + this.id + "-indent-" + i + "\" src=\"" + ((foo._last)?KTreeConfig.blankIcon:KTreeConfig.iIcon) + "\">" + indent;
		i++;
	}
	this._level = i;
	if (this.childNodes.length) { this.folder = 1; }
	else { this.open = false; }
	if ((this.folder) || (KTreeHandler.behavior != 'classic')) {
		if (!this.icon) { this.icon = KTreeConfig.folderIcon; }
		if (!this.openIcon) { this.openIcon = KTreeConfig.openFolderIcon; }
	}
	else if (!this.icon) { this.icon = KTreeConfig.fileIcon; }
	var label = this.text.replace(/</g, '&lt;').replace(/>/g, '&gt;');
	var str = "<div id=\"" + this.id + "\"  class=\"webfx-tree-item\" onkeydown=\"return KTreeHandler.keydown(this, event)\">" +
		indent +
		"<img id=\"" + this.id + "-plus\" src=\"" + ((this.folder)?((this.open)?((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon):((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon)):((this.parentNode._last)?KTreeConfig.lIcon:KTreeConfig.tIcon)) + "\" onclick=\"KTreeHandler.toggle(this);\">" +
		"<img id=\"" + this.id + "-icon\" class=\"webfx-tree-icon\" src=\"" + ((KTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"KTreeHandler.toggle(this);\">" +
		"<a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\"  onfocus=\"KTreeHandler.focus(this);\" onblur=\"KTreeHandler.blur(this);\"" +
		(this.target ? " target=\"" + this.target + "\"" : "") +
		">" + label + "</a></div>" +
		"<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
	var sb = [];
	for (var i = 0; i < this.childNodes.length; i++) {
		sb[i] = this.childNodes[i].toString(i,this.childNodes.length);
	}
	this.plusIcon = ((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon);
	this.minusIcon = ((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon);
	return str + sb.join("") + "</div>";
}





KTreeConfig.loadingText = "Loading...";
KTreeConfig.loadErrorTextTemplate = "Error loading \"%1%\"";
KTreeConfig.emptyErrorTextTemplate = "Error \"%1%\" does not contain any tree items";

/*
 * KLoadTree class
 */

function KLoadTree(sText, sXmlSrc, sAction, sBehavior, sIcon, sOpenIcon) {
	// call super
	//debugger;
	this.KTree = KTree;
	this.KTree(sText, sAction, sBehavior, sIcon, sOpenIcon);

	// setup default property values
	this.src = sXmlSrc;
	this.loading = false;
	this.loaded = false;
	this.errorText = "";

	// check start state and load if open
	if (this.open)
		_startLoadXmlTree(this.src, this);
	else {
		// and create loading item if not
		this._loadingItem = new KTreeItem(KTreeConfig.loadingText);
		this.add(this._loadingItem);
	}
}

KLoadTree.prototype = new KTree;

// override the expand method to load the xml file
KLoadTree.prototype._webfxtree_expand = KTree.prototype.expand;
KLoadTree.prototype.expand = function() {
	if (!this.loaded && !this.loading) {
		// load
		_startLoadXmlTree(this.src, this);
	}
	this._webfxtree_expand();
};

/*
 * KLoadTreeItem class
 */

function KLoadTreeItem(sText, sXmlSrc, sAction,checkbox, eParent, sIcon, sOpenIcon) {
	// call super
	this.KTreeItem = KTreeItem;
	this.KTreeItem(sText, sAction, eParent, sIcon, sOpenIcon);

	// setup default property values
	this.src = sXmlSrc;
	this.loading = false;
	this.loaded = false;
	this.errorText = "";

	// check start state and load if open
	if (this.open)
		_startLoadXmlTree(this.src, this);
	else {
		// and create loading item if not
		this._loadingItem = new KTreeItem(KTreeConfig.loadingText);
		this.add(this._loadingItem);
	}
}

KLoadTreeItem.prototype = new KTreeItem;

// override the expand method to load the xml file
KLoadTreeItem.prototype._webfxtreeitem_expand = KTreeItem.prototype.expand;
KLoadTreeItem.prototype.expand = function() {
	if (!this.loaded && !this.loading) {
		// load
		_startLoadXmlTree(this.src, this);
	}
	this._webfxtreeitem_expand();
};

// reloads the src file if already loaded
KLoadTree.prototype.reload =
KLoadTreeItem.prototype.reload = function () {
	// if loading do nothing
	if (this.loaded) {
		var open = this.open;
		// remove
		while (this.childNodes.length > 0)
			this.childNodes[this.childNodes.length - 1].remove();

		this.loaded = false;

		this._loadingItem = new KTreeItem(KTreeConfig.loadingText);
		this.add(this._loadingItem);

		if (open)
			this.expand();
	}
	else if (this.open && !this.loading)
		_startLoadXmlTree(this.src, this);
};

/*
 * Helper functions
 */

// creates the xmlhttp object and starts the load of the xml document
function _startLoadXmlTree(sSrc, jsNode) {
	if (jsNode.loading || jsNode.loaded)
		return;
	jsNode.loading = true;
	
	var xmlDoc;
	if (window.DOMParser)
	{
	    parser=new DOMParser();
	    $.get(sSrc,function(xml){
	    	xmlDoc=parser.parseFromString(xml,"text/xml");
	    	_xmlFileLoaded(xmlDoc, jsNode);
	    })
	    
	}
	else // Internet Explorer
	{
	    xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	    xmlDoc.async=false;
	    xmlDoc.loadXML(sSrc); 
	    _xmlFileLoaded(xmlDoc, jsNode);
	}
	
//	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
//		xmlDoc.async="false";
//		xmlDoc.load(sSrc);
	

	
}


// Converts an xml tree to a js tree. See article about xml tree format
function _xmlTreeToJsTree(oNode) {
	// retreive attributes
	var text = oNode.getAttribute("Title");
	var action = oNode.getAttribute("Href");
	
	var parent = null;
	var icon = oNode.getAttribute("Icon");
	var openIcon = oNode.getAttribute("OpenIcon");
	var src = oNode.getAttribute("Src");
	var target = oNode.getAttribute("Target");
	var checkbox=oNode.getAttribute("Checkbox");
	var radio=oNode.getAttribute("Radio");
	var value=oNode.getAttribute("value");
	// create jsNode
	var jsNode;
	if (src != null && src != "")
		jsNode = new KLoadTreeItem(text, src, action,checkbox, parent, icon, openIcon);
	else if (checkbox != null && checkbox!= "")
		jsNode = new KCheckBoxTreeItem(text, action, parent, icon, openIcon,checkbox=="true",value);
	else if (radio != null && radio!= "")
		jsNode = new KRadioTreeItem(text, action, parent, icon, openIcon,radio=="true",value);
    else
		jsNode = new KTreeItem(text, action, parent, icon, openIcon);

	if (target != "")
		jsNode.target = target;

	// go through childNOdes
	var cs = oNode.childNodes;
	var l = cs.length;
	for (var i = 0; i < l; i++) {
		if (cs[i].tagName == "item")
			jsNode.add( _xmlTreeToJsTree(cs[i]), true );
	}

	return jsNode;
}

// Inserts an xml document as a subtree to the provided node
function _xmlFileLoaded(oXmlDoc, jsParentNode) {
	if (jsParentNode.loaded)
		return;

	var bIndent = false;
	var bAnyChildren = false;
	jsParentNode.loaded = true;
	jsParentNode.loading = false;

	// check that the load of the xml file went well
	if( oXmlDoc == null || oXmlDoc.documentElement == null) {
		alert(oXmlDoc.xml);
		jsParentNode.errorText = parseTemplateString(KTreeConfig.loadErrorTextTemplate,
							jsParentNode.src);
	}
	else {
		// there is one extra level of tree elements
		var root = oXmlDoc.documentElement;

		// loop through all tree children
		var cs = root.childNodes;
		var l = cs.length;
		for (var i = 0; i < l; i++) {
			if (cs[i].tagName == "item") {
				bAnyChildren = true;
				bIndent = true;
				jsParentNode.add( _xmlTreeToJsTree(cs[i]), true);
			}
		}

		// if no children we got an error			Zerrionע��
		//if (!bAnyChildren)
			//jsParentNode.errorText = parseTemplateString(KTreeConfig.emptyErrorTextTemplate,jsParentNode.src);
	}

	// remove dummy
	if (jsParentNode._loadingItem != null) {
		jsParentNode._loadingItem.remove();
		bIndent = true;
	}

	if (bIndent) {
		// indent now that all items are added
		jsParentNode.indent();
	}

	// show error in status bar
	if (jsParentNode.errorText != "")
		window.status = jsParentNode.errorText;
}

// parses a string and replaces %n% with argument nr n
function parseTemplateString(sTemplate) {
	var args = arguments;
	var s = sTemplate;

	s = s.replace(/\%\%/g, "%");

	for (var i = 1; i < args.length; i++)
		s = s.replace( new RegExp("\%" + i + "\%", "g"), args[i] )

	return s;
}

function KCheckBoxTreeItem(sText, sAction,  eParent, sIcon, sOpenIcon,bChecked,value) {
	this.base = KTreeItem;
	this.base(sText, sAction, eParent, sIcon, sOpenIcon);
	
	this._checked = bChecked;
	this._value=value;
}

KCheckBoxTreeItem.prototype = new KTreeItem;

KCheckBoxTreeItem.prototype.toString = function (nItem, nItemCount) {
	var foo = this.parentNode;
	var indent = '';
	if (nItem + 1 == nItemCount) { this.parentNode._last = true; }
	var i = 0;
	while (foo.parentNode) {
		foo = foo.parentNode;
		indent = "<img id=\"" + this.id + "-indent-" + i + "\" src=\"" + ((foo._last)?KTreeConfig.blankIcon:KTreeConfig.iIcon) + "\">" + indent;
		i++;
	}
	this._level = i;
	if (this.childNodes.length) { this.folder = 1; }
	else { this.open = false; }
	if ((this.folder) || (KTreeHandler.behavior != 'classic')) {
		if (!this.icon) { this.icon = KTreeConfig.folderIcon; }
		if (!this.openIcon) { this.openIcon = KTreeConfig.openFolderIcon; }
	}
	else if (!this.icon) { this.icon = KTreeConfig.fileIcon; }
	var label = this.text.replace(/</g, '&lt;').replace(/>/g, '&gt;');
	var str = "<div id=\"" + this.id + "\"  class=\"webfx-tree-item\" onkeydown=\"return KTreeHandler.keydown(this, event)\">";
	str += indent;
	str += "<img id=\"" + this.id + "-plus\" src=\"" + ((this.folder)?((this.open)?((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon):((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon)):((this.parentNode._last)?KTreeConfig.lIcon:KTreeConfig.tIcon)) + "\" onclick=\"KTreeHandler.toggle(this);\">"
	
	// insert check box
	str += "<input type=\"checkbox\"" +
		" class=\"tree-check-box\"" +
		(this._checked ? " checked=\"checked\"" : "") +
		" value=\"" + this._value + "\" " +
		" />";
	// end insert checkbox
	
	str += "<img id=\"" + this.id + "-icon\" class=\"webfx-tree-icon\" src=\"" + ((KTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"KTreeHandler.toggle(this);\"><a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\"  onfocus=\"KTreeHandler.focus(this);\" onblur=\"KTreeHandler.blur(this);\">" + label + "</a></div>";
	str += "<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
	for (var i = 0; i < this.childNodes.length; i++) {
		str += this.childNodes[i].toString(i,this.childNodes.length);
	}
	str += "</div>";
	this.plusIcon = ((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon);
	this.minusIcon = ((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon);
	return str;
}

function KRadioTreeItem(sText, sAction,  eParent, sIcon, sOpenIcon,bChecked,value) {
	this.base = KTreeItem;
	this.base(sText, sAction, eParent, sIcon, sOpenIcon);	
	this._checked = bChecked;
	this._value=value;
}

KRadioTreeItem.prototype = new KTreeItem;

KRadioTreeItem.prototype.toString = function (nItem, nItemCount) {
	var foo = this.parentNode;
	var indent = '';
	if (nItem + 1 == nItemCount) { this.parentNode._last = true; }
	var i = 0;
	while (foo.parentNode) {
		foo = foo.parentNode;
		indent = "<img id=\"" + this.id + "-indent-" + i + "\" src=\"" + ((foo._last)?KTreeConfig.blankIcon:KTreeConfig.iIcon) + "\">" + indent;
		i++;
	}
	this._level = i;
	if (this.childNodes.length) { this.folder = 1; }
	else { this.open = false; }
	if ((this.folder) || (KTreeHandler.behavior != 'classic')) {
		if (!this.icon) { this.icon = KTreeConfig.folderIcon; }
		if (!this.openIcon) { this.openIcon = KTreeConfig.openFolderIcon; }
	}
	else if (!this.icon) { this.icon = KTreeConfig.fileIcon; }
	var label = this.text.replace(/</g, '&lt;').replace(/>/g, '&gt;');
	var str = "<div id=\"" + this.id + "\"  class=\"webfx-tree-item\" onkeydown=\"return KTreeHandler.keydown(this, event)\">";
	str += indent;
	str += "<img id=\"" + this.id + "-plus\" src=\"" + ((this.folder)?((this.open)?((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon):((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon)):((this.parentNode._last)?KTreeConfig.lIcon:KTreeConfig.tIcon)) + "\" onclick=\"KTreeHandler.toggle(this);\">"
	
	// insert check box
	str += "<input name=\"item\" type=\"radio\"" +
		" class=\"tree-check-box\"" +
		(this._checked ? " checked=\"checked\"" : "") +
		" value=\"" + this._value + "\" " +
		" />";
	// end insert checkbox
	
	str += "<img id=\"" + this.id + "-icon\" class=\"webfx-tree-icon\" src=\"" + ((KTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"KTreeHandler.toggle(this);\"><a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\" onfocus=\"KTreeHandler.focus(this);\" onblur=\"KTreeHandler.blur(this);\">" + label + "</a></div>";
	str += "<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
	for (var i = 0; i < this.childNodes.length; i++) {
		str += this.childNodes[i].toString(i,this.childNodes.length);
	}
	str += "</div>";
	this.plusIcon = ((this.parentNode._last)?KTreeConfig.lPlusIcon:KTreeConfig.tPlusIcon);
	this.minusIcon = ((this.parentNode._last)?KTreeConfig.lMinusIcon:KTreeConfig.tMinusIcon);
	return str;
}

