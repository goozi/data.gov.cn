<HTML><HEAD><TITLE>Untitled Document</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<SCRIPT>
function switchMenu() {
	if (document.all.switchImg.src.indexOf("menu_switch_close") > 0) {
		top.close();
		document.all.switchImg.src = "images/outlook/menu_switch_expand.gif";
	} else if (document.all.switchImg.src.indexOf("menu_switch_expand") > 0) {
		top.expand();
		document.all.switchImg.src = "images/outlook/menu_switch_close.gif";
	}
}
</SCRIPT>

<META content="MSHTML 6.00.2600.0" name=GENERATOR></HEAD>
<BODY bgColor=#fcfaf3 leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" align=center 
border=0>
  <TBODY>
	  <TR>
		<TD vAlign=top width=10 background="images/outlook/left_right_bg.gif">
			  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
          <TBODY>
					<TR>
					  <TD width=10 height=10><IMG height=10 
						src="images/outlook/left_right_jiao.gif" width=10></TD></TR>
					<TR>
					  <TD>&nbsp;</TD></TR>
					<TR>
					  <TD><IMG id=switchImg onclick=switchMenu(); height=70 
						src="images/outlook/menu_switch_close.gif" width=10></TD></TR>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
		</TD>
	</TR>
  </TBODY>
 </TABLE>
 </BODY>
 </HTML>
