
/*!
 * aYin's Lib copyright 2020
 * ayin86@163.com  yinzhijun@dhcc.com.cn
 * only use for owen project.
 * contain open source project:"jquery-Browser,jquery cookie"
 */

(function($){
    var $pPage;
    if(typeof(portletPage)=="undefined"){$pPage="portlet.html"}else{$pPage=portletPage;}
    $.writeURL=function(opts){
        var options=$.extend({},$.writeURL.defaults,opts);
        var snav,cont,frameClick=false;
        if($("#sideNavLayout").length==1){snav=$("#sidenav");}
        else{snav=$(window.top.document).find("#sidenav");frameClick=true;}
        if($("#contentLayout").length==1){cont=$("#content");}
        else{cont=$(window.top.document).find("#content");}
            if(frameClick==false){
                if(options.sidenav!=""){
                    snav.find(".frameLoading").show();
                    if($(".ui-layout-west").length==1){myLayout.addPane('west');}
                    //pool.find("#sidenavFrame").appendTo(snav);
                    snav.find("#sidenavFrame").attr("src",options.sidenav);
                }else{
                    if($(".ui-layout-west").length==1){myLayout.removePane('west');}
                }
            }
        cont.find(".frameLoading").show();
        cont.find("#contentFrame").attr("src",options.content);
    };
    $.writeURL.defaults={
       sidenav:"",
       content:$pPage
    };
})(jQuery);


(function($){
    $.fn.interaction = function(options,callback){
        //if(options.type==null){}
        var settings={
            overAction:false,
            noInt:"",
            addClass:"",
            type:""
        }
        var opts=$.extend(settings,options);
        var $eobj=this;
        $eobj.each(function(x,eobj){
            var li=$(eobj).children("li");
            if($(li).length>0){
                $(li).each(function(i,obj){
                    oldClass(obj);
                    $(obj).addClass("btn "+"btn"+(i+1));
                    if(i==0){$(obj).addClass("btnFrist")}else 
                    if(i==$(li).length-1){$(obj).addClass("btnLast")}
                    //if($(obj).hasClass('noInt')==false){actions($(obj),opts.type);}
                    if(opts.noInt&&(
                        (i==0&&opts.noInt.search("first")>-1)||
                        (opts.noInt.search(i+1)>-1)||
                        (i==$(li).length-1&&opts.noInt.search("last")>-1))){}
                    else{
                        actions($(obj),opts.type);
                    }
                    if(opts.addClass){
                        for(var name in opts.addClass){
                            if(parseInt(name.replace(/^li/img,""))==i+1){
                                $(obj).addClass(opts.addClass[name]);
                            }
                        }
                        if(opts.addClass.last&&i==$(li).length-1){
                            $(obj).addClass(opts.addClass.last);
                        }
                        if(opts.addClass.first&&i==0){
                            $(obj).addClass(opts.addClass.first);
                        }
                    }
                });
            }else{
                oldClass(eobj);
                actions(eobj,opts.type);
                if(opts.addClass){
                    $(eobj).addClass(opts.addClass);
                }
            }
            
            
        });
        function oldClass(obj){
            if($(obj).attr("class")){
                $(obj).data("oldclass",$.trim($(obj).attr("class")).split(" ")[0]);
                //alert($(obj).data("oldclass"));
            }
        }
        function actions(obj,what){
            if(opts.type!="input"){
                $(obj).bind("mouseenter",function(){
                    $(this).addClass("hover");
                    if($(this).data("oldclass")){
                        $(this).addClass($(this).data("oldclass")+"-hover");
                    }
                    //alert($(this).attr("class"))
                });
                $(obj).bind("mouseleave",function(){
                    $(this).removeClass("hover");
                    if($(this).data("oldclass")){
                        $(this).removeClass($(this).data("oldclass")+"-hover");
                    }
                });
                if(what=="radio"||what=="label"){
                    var judgeAction=function(){if(opts.overAction==true){return "mouseover"}else{return "click"}}
                    $(obj).bind(judgeAction(),function(){
                        var eobj=this;
                        var bro=$(this).parent().children();
                        $(bro).each(function(i,bro2){
                            if(bro2==eobj){
                                $(bro2).addClass("active");
                                if($(bro2).data("oldclass")){
                                    $(bro2).addClass($(bro2).data("oldclass")+"-active");
                                }
                            }else{
                                $(bro2).removeClass("active");
                                if($(bro2).data("oldclass")){
                                    $(bro2).removeClass($(bro2).data("oldclass")+"-active");
                                }
                            }
                          
                        });
                    });
                }else if(what=="checkbox"){
                    $(obj).bind("click",function(){
                            if($(this).hasClass("active")){
                                $(this).removeClass("active")
                                if($(this).data("oldclass")){
                                    $(this).removeClass($(this).data("oldclass")+"-active");
                                }
                            }else{
                                $(this).addClass("active")
                                if($(this).data("oldclass")){
                                    $(this).addClass($(this).data("oldclass")+"-active");
                                }
                            }
                        }
                    );
                }else if(what=="button"){
                    $(obj).bind("mousedown",function(){
                        $(this).addClass("active");
                        if($(this).data("oldclass")){
                            $(this).addClass($(this).data("oldclass")+"-active");
                        }
                    });
                    $(obj).bind("mouseup",function(){
                        $(this).removeClass("active");
                        if($(this).data("oldclass")){
                            $(this).removeClass($(this).data("oldclass")+"-active");
                        }
                    });
                    $(obj).bind("mouseleave",function(){
                        $(this).removeClass("active");
                        if($(this).data("oldclass")){
                            $(this).removeClass($(this).data("oldclass")+"-active");
                        }
                    });
                }
             }else{
                $(obj).bind("focus",function(){
                    $(this).removeClass("blur");
                    $(obj).addClass("focus");
                    if($(this).data("oldclass")){
                        $(this).removeClass($(this).data("oldclass")+"-blur");
                        $(this).addClass($(this).data("oldclass")+"-focus");
                    }
                });
                $(obj).bind("blur",function(){
                    if($(this).val()==""){
                        $(this).removeClass("focus");
                        $(this).removeClass("blur");
                        if($(this).data("oldclass")){
                            $(this).removeClass($(this).data("oldclass")+"-focus");
                            $(this).removeClass($(this).data("oldclass")+"-blur");
                        }
                    }else{
                        $(this).removeClass("focus");
                        $(this).addClass("blur");
                        if($(this).data("oldclass")){
                            $(this).removeClass($(this).data("oldclass")+"-focus");
                            $(this).addClass($(this).data("oldclass")+"-blur");
                        }
                    }
                });
             }
        }
    }
})(jQuery);




(function($){
    $.fn.tree2nd = function(options,callback){
        //if(options.type==null){}
         var settings={
            theme:"whiteBlue",
            //active:"2,3",
            onlyOneActive:true
            //width:300
            
        }
        var opts=$.extend(settings,options);
        
        var $tree=this;
        $tree.each(function(i,tree){
            $(tree).addClass("tree").wrap("<div class='treeWrap'/>");
            if(opts.width!=null){
                $(tree).parent().width(opts.width);
            }
            var all=$(tree).find("*").andSelf();
            $(all).each(function(j,ano){
               var my=$(ano).parents("ul").parentsUntil(".tree").end();
               var step=$(my).length+1;
               if($(ano).is("ul")){
                   $(ano).addClass("tree-Ul tree-Ul"+step);
                   var chi=$(ano).children();
                    $(chi).each(function(k,chi2){
                        $(chi2).addClass("tree-Li tree-Li"+step+"-"+k);
                        var snlc=$(chi2).children("ul");
                        $(snlc).detach();
                        $(chi2).wrapInner("<div class='tree-Div'><span \/><\/div>");
                        $(chi2).find("span").addClass("tree-Desc");
                        $(chi2).find("span").parent().prepend("<span><\/span>");
                        $(chi2).append(snlc);
                        $(chi2).find("span").first().addClass("treeState");
                        if($(chi2).find(".tree-Desc").find(".fa").size()<=0){
                            $(chi2).find(".tree-Desc").prepend("<span class='treeIcon'><\/span>");
                        }
                        
                        var tDiv=$(chi2).children(".tree-Div");
                        $(tDiv).css("padding-left",15*(step)).addClass("tree-Div"+step+k+" "+"tree-Div"+step);
                        var subUl=$(chi2).children("ul");
                        if($(subUl).length>0){
                            $(tDiv).addClass("withSub");
                            $(subUl).hide();
                        }
                        $(tDiv).bind("click",function(){
                            var eobj=this;
                            if(opts.onlyOneActive==true){
                                var bro=$(eobj).parent().siblings().andSelf();
                            }else{
                                var bro=$(tree).find("li");
                            }
                            
                            $(bro).each(function(k,bro2){
                               var subUl=$(bro2).children("ul");
                               var tDiv=$(bro2).children(".tree-Div");
                              
                               if(tDiv[0]==eobj){
                                   if($(eobj).hasClass("open")){
                                            $(eobj).siblings("ul").slideUp("",function(){
                                                $(eobj).removeClass("open");
                                            });
                                   }else{
                                       if($(eobj).siblings("ul").size()>0){
                                            $(eobj).siblings("ul").slideDown();
                                            $(eobj).addClass("open");
                                        }else{
                                            $(eobj).addClass("active");
                                        }
                                   }
                               }else{
                                    if(opts.onlyOneActive==true){
                                            $(bro2).find(".tree-Div").removeClass("active open");
                                           // alert($(eobj).siblings("ul").size()<=0)
                                        if($(eobj).siblings("ul").size()<=0){
                                        }else{
                                        }
                                        $(bro2).find("ul").slideUp();
                                    }else{
                                        if($(eobj).siblings("ul").size()<=0){
                                            $(bro2).children(".tree-Div").removeClass("active");
                                        }
                                    }
                                }
                            });
                        });
                        $(tDiv).hover(function(){
                            $(this).toggleClass("hover");
                        });
                        
                        
                        
                        var aCount=opts.active.split(",");
                        //alert(aCount.length);
                        for(m=0;m<aCount.length;m++){
                           if(step==(m+1)&&parseInt(aCount[m])==(k+1)){
                               //alert($(chi2).text())
                               if($(chi2).children("ul").size()>0){
                                   $(chi2).parents("ul").show();
                                   $(chi2).parents("ul").siblings(".tree-Div").addClass("open");
                                   $(chi2).find("ul").show();
                                   $(chi2).find("ul").siblings(".tree-Div").addClass("open");
                                   //alert($(chi2).find("ul").text())
                               }else{
                                   $(chi2).find(".tree-Div").addClass("active");
                               }
                           }
                        }
                        
                        
                        
                    });
               }
            });
        });
   }
})(jQuery);





(function($){
    $.fn.tree = function(options,callback){
        //if(options.type==null){}
        var settings={
            theme:"whiteBlue",
            active:"none",
            /*
            active:"normal","node1_node2_node1"
            icon:{
                allFolder:"x13 y11",
                //allNodes:"x12 y11",
                //node1_folder:"",
                //node1_nodes:"",
                node1_folder:"folder",
                node1_node4_nodes:"nodes",
                node1_node4_node1:"x1 y2"
                //node1_node1:"",
                //node1_node2:"",
                //node2_node1:"",
                //node2_node2:""
            },
            addClass:{
                allFolder:"",
                allNodes:"",
                node1_folder:"",
                node1_nodes:"",
                node2_folder:"",
                node2_nodes:"",
                node1_node1:"",
                node1_node2:"",
                node2_node1:"",
                node2_node2:""
            },
            */
            overAction:false,
            onlyOneActive:true,
            autoResize:true
        }
        var opts=$.extend(settings,options);
        
        
        /*
        var names=new Array(); 
        for(var name in opts.icon){
           if(name!="allFolder"&&name!="allNodes"){
               var loc=name.split("_");
               for(i=0;i<loc.length;i++){
                   if(loc[i]=="folder"){
                        //alert(name.replace(/folder$/img,""))
                   }else if(loc[i]=="nodes"){
                       //alert("nodes"+i)
                   }else{
                       //alert(i)
                   }
               }
               //alert(name.replace(/node/img,""))
                if(opts.icon[name]=="allFolder"){
                    //alert(opts.icon[name]);
                }
           }else{
               if(name=="allFolder"){
                
                }
                if(name=="allNodes"){

                }
           }
        }*/
        
        
        var $tree=this;
        $tree.each(function(i,tree){
            $(tree).addClass("tree").wrap("<div class='treeWrap'/>");
            
            var all=$(tree).find("*").andSelf();
            $(all).each(function(j,ano){
               var my=$(ano).parents("ul").parentsUntil(".tree").end();
               var step=$(my).length+1;
               if($(ano).is("ul")){
                   $(ano).addClass("tree-Ul tree-Ul"+step);
                   var chi=$(ano).children();
                   $(chi).addClass("tree-Li tree-Li"+step);
                    $(chi).each(function(k,chi2){
                        var snlc=$(chi2).children("ul");
                        $(snlc).detach();
                        $(chi2).wrapInner("<div class='tree-Div'><span \/><\/div>");
                        $(chi2).find("span").addClass("tree-Desc");
                        $(chi2).find("span").parent().prepend("<span><\/span><span><\/span>");
                        $(chi2).append(snlc);
                        $(chi2).find("span").first().addClass("iconState");
                        var spanIcon=$(chi2).find("span").first().next();
                        spanIcon.addClass("iconTree");
                        
                        if(opts.icon){
                            if(step==1){
                                $(chi2).addClass("node"+(k+1));
                                if(opts.icon.allFolder&&$(chi2).children("ul").length>0){
                                    spanIcon.removeClass("iconTree").addClass(opts.icon.allFolder+" icon");
                                }
                                if(opts.icon.allNodes&&$(chi2).children("ul").length==0){
                                    spanIcon.removeClass("iconTree").addClass(opts.icon.allNodes+" icon");
                                }
                            }else{
                                var pc=$(chi2).parent().parent().attr("class");
                                var pcG=pc.split(" ");
                                var nodeCount="";
                                for(a=0;a<pcG.length;a++){
                                    if(pcG[a].search("node")>-1){
                                        nodeCount=pcG[a];
                                    }
                                }
                                $(chi2).addClass(nodeCount+"_node"+(k+1));
                                for(var name in opts.icon){
                                    if(name.replace(/_folder$/img,"")==nodeCount&&$(chi2).children("ul").length>0
                                    ||name.replace(/_nodes$/img,"")==nodeCount&&$(chi2).children("ul").length==0
                                    ||name==(nodeCount+"_node"+(k+1))
                                    ||name=="allFolder"&&$(chi2).children("ul").length>0
                                    ||name=="allNodes"&&$(chi2).children("ul").length==0){
                                        spanIcon.removeClass().addClass(opts.icon[name]+" icon");
                                    }
                                }
                            }
                        }
                        
                        
                        var tDiv=$(chi2).children(".tree-Div");
                        $(tDiv).css("padding-left",15*(step)).addClass("tree-Div"+step);
                        var subUl=$(chi2).children("ul");
                        if($(subUl).length>0){
                            $(tDiv).addClass("withSub");
                            $(subUl).hide();
                        }
                        $(chi2).bind("click",function(){
                            var eobj=this;
                            var bro=$(eobj).parent().children();
                            if(opts.onlyOneActive==true){bro=$(all).find(".tree-Li");}
                            $(bro).each(function(k,bro2){
                               var subUl=$(bro2).children("ul");
                               var tDiv=$(bro2).children(".tree-Div");
                               if(bro2==eobj){
                                    if($(bro2).has("ul").length>0){
                                        
                                        $(subUl).slideDown("",function(){
                                            if($(subUl).is("ul:visible")==false){
                                                $(tDiv).removeClass("active open");
                                            }
                                        });
                                        $(tDiv).toggleClass("active");
                                    }else{
                                        $(tDiv).addClass("active");
                                    }
                               }else{
                                   if($(tDiv).hasClass("active")){
                                       $(tDiv).removeClass("active");
                                       $(tDiv).addClass("open");
                                   }
                               }
                            });
                             
                            var liBro=$(all).find(".tree-Li"+step);
                            $(liBro).each(function(l,liBro2){
                              
                               var tDiv=$(liBro2).find(".tree-Div");
                               var subUl=$(liBro2).children("ul");
                               var allUl=$(liBro2).find("ul");
                               if(liBro2!=eobj){
                                   $(tDiv).removeClass("active");
                                   $(tDiv).removeClass("open");
                                   $(subUl).slideUp("",function(){$(allUl).hide();});
                               }
                            });
                            return false;
                        });
                        $(tDiv).hover(function(){
                            $(this).toggleClass("hover");
                        })
                    });
               }
            });
        });
   }
})(jQuery);





(function($){
    $.fn.tableList = function(options, callback){
        var settings={
            width:"100%",
            height:"",
            //icon:"x1 y1",
            checkbox:false,
            radio:false,
            cutStr:true,
            tdWidth:{
                tdLast:"10%"
            }
        }
        var opts=$.extend(settings,options);
        var $tList=this;
        $tList.each(function(x,tList){
            var $tr=$(tList).find("tr"),
                $td=$($tr).children("td");
                
            $(tList).attr({"cellSpacing":"0","cellPadding":"0"}).data("inited","true").addClass("tableList").wrap("<div class='tableListWrap' />");
            var $tlw=$(tList).parent();
            if($tlw.parent().is("td")){
                $tlw.parent().width($tlw.parent().width());
            }
            if(opts.width&&opts.width!="100%"){
                $tlw.width(opts.width).show();
            }
            
            //else if($tlw.parent().is("td")){$tlw.width($tlw.parent().innerWidth()-100).show();}
            if(opts.height){
                $tlw.height(opts.height);
            }
            $tr.bind("mouseover",function(){$(this).addClass("hover");});
            $tr.bind("mouseout",function(){$(this).removeClass("hover");});
            $tr.filter(":even").addClass("even");
            $tr.filter(":odd").addClass("odd");
            //alert(opts.tdWidth.length)
            //opts.tdWidth.toString().split().length
            for(var name in opts.tdWidth){
                //alert(opts.tdWidth[name]+" "+name);
            }
            if($(tList).find("tbody").size()==0||$(tList).find("tbody").children().size()==0){$(tList).parent().append("<div class='noContent'/>")}
            $tr.each(function(i,tr){
                var $td=$(tr).children("td,th");
                $td.each(function(j,td){
                    $(td).attr("title",$.trim($(td).text()));
                    $(td).addClass("tdData"+(j+1));
                    if(j==0){$(td).addClass("tdDataFirst");}
                    else if(j==$td.length-2&&$($td).length>3){$(td).addClass("tdDataNTL");}
                    else if(j==$td.length-1&&$($td).length>2){$(td).addClass("tdDataLast");}
                    if($(td).html()==""){$(td).append("<font>&nbsp;</font>")}
                    
                    if($(td).children().size()==1&&($(td).children().first().is("a")||$(td).children().first().is("font"))||$(td).children().size()==0){
                        if(opts.cutStr){
                            $(td).wrapInner("<div class='fontWrap'/>");
                        }
                        $(td).find(".fontWrap").css({
                            //height:parseInt($(td).css("font-size"))+2
                        });
                    }
                    if(i==0){
                        for(var name in opts.tdWidth){
                            if(parseInt(name.replace(/^td/img,""))==j+1){
                                $(td).width(opts.tdWidth[name]);
                            }
                        }
                        if(opts.tdWidth.tdLast&&$td.length==j+1&&$td.length!=1){
                            $(td).width(opts.tdWidth.tdLast);
                        }
                        if(opts.tdWidth.tdFirst&&j==0){
                            $(td).width(opts.tdWidth.tdFirst);
                        }
                    }
                    /*
                    if(i==1&&j==0){
                        for(w=0;w<$(td).text().size();w++){
                            
                        }
                        alert($(td).text()[0].width())
                    }
                    */
                });
            });
            
            $tr.each(function(i,tr){
                 //icon
                if(opts.icon){
                    if($(tr).parent().is("thead")){
                        $(tr).prepend("<th class='tdIcon'><span class='icon' style='display:none' /></th>");
                    }else{
                        $(tr).prepend("<td class='tdIcon'><span class='icon'/></td>");
                    }
                    $(tr).find(".tdIcon").find(".icon").addClass(opts.icon);
                    if(i==0){
                        $(tr).find(".tdIcon").find(".icon").parent().width(16);
                    }
                    //alert($(tr).html())
                }
                
                //checkbox
                if(opts.checkbox){
                    if($(tr).parent().is("thead")){
                        $(tr).prepend("<th class='tdCheckbox'><input class='TL-checkbox' type='checkbox' title='\u5168\u9009'/></th>");
                    }else{
                        $(tr).prepend("<td class='tdCheckbox'><input class='TL-checkboxSub' type='checkbox'/></td>");
                    }
                    if(i==0){
                        $(tr).find(".TL-checkbox").parent().width(20).end().click(function(){
                            $tr.find(".TL-checkboxSub").attr("checked",this.checked);
                            $tr.find(".TL-checkboxSub").click(function(){
                                $tr.find(".TL-checkbox").attr("checked",$tr.find(".TL-checkboxSub").length == $tr.find(".TL-checkboxSub:checked").length ? true : false);
                            });
                        });
                    }
                }
                //radio
                if(opts.radio){
                    if($(tr).parent().is("thead")){
                        $(tr).prepend("<th class='tdRadio'><input class='TL-radio' type='radio' title='\u7A7A'/></th>");
                    }else{
                        $(tr).prepend("<td class='tdRadio'><input class='TL-radio' type='radio'/></td>");
                    }
                    if(i==0){
                        $(tr).find(".TL-radio").parent().width(16);
                    }
                    $tr.find(".TL-radio").click(function(){
                        var eobj=this;
                        $tr.find(".TL-radio").each(function(RI,radio){
                            if(eobj==radio){
                                $(radio).attr("checked",function(){
                                    
                                });
                            }else{
                                $(radio).attr("checked",false);
                            }
                        });
                    });
                }
               
                
                var $td=$(tr).children("td,th");
                $td.each(function(j,td){
                    if(i==0){
                        if(j==0){
                            $(td).css({"border-left-width":0});
                        }else if(j==$td.size()-1){
                            $(td).css({"border-right-width":0});
                        }
                    }
                });
                
            });
            //var tr0td=$($tr).filter(":eq(0)").children("td");
             bindResize=function($tlw){
                $(window).one("resize",function(){
                    if($tlw.parent().is("td")){
                        bindResize($tlw);
                        $tlw.parent().width("");
                        $.timer.set($tlw.attr("class")+x,function(){
                            clearTLW($tf,TDTitleWidth,inputResize,inputFoceResize);
                            setTimeout(function(){bindResize($tf,TDTitleWidth,inputResize,inputFoceResize)},300)
                        },300)
                    }
                    /*
                    if($tf.is(":hidden")){bindResize($tf,opts.TDTitleWidth,opts.inputResize,opts.inputFoceResize);return;}
                    $tf.data("resizing","ture");
                    $.timer.set($tf.attr("class")+x,function(){
                        clearTLW($tf,TDTitleWidth,inputResize,inputFoceResize);
                        setTimeout(function(){bindResize($tf,TDTitleWidth,inputResize,inputFoceResize)},300)
                    },300)
                    $tf.data("resizing",null);
                    */
                    
                 })
             }
             bindResize($tlw);
        });
    }
})(jQuery);

(function($){
    $.fn.tableForm = function(options, callback){
        var settings={
            width:"100%",
            height:"",
            TDTitleWidth:150,
            inputWidth:"100%",
            inputHeight:30,
            inputResize:true,
            inputFoceResize:true,
            hiddenColon:false,
            autoResize:true,
            className:""
        }
        var opts=$.extend(settings,options);
        var $tForm=this;
        $tForm.each(function(x,tForm){
            var $tf=$(tForm),
            $tbody=$tf.children(),
            $tr=$tbody.children();
            $tf.addClass(opts.className);
            //$(tForm).find("table").data("formlink","true").hide();
            if($tf.parent().is("td")){
                $tf.wrap("<div class='tableFormWrap'/>");
            }else{
                $tf.wrap("<div class='tableFormOuterWrap'><div class='tableFormWrap'/></div>");
            }
            if($tf.data("inited")!=null){return;}
            $tf.data("inited","true");
            $tf.css({height:opts.height}).addClass("tableForm");
            $tr.each(function(i,tr){
                var $td=$(tr).children();
                $td.each(function(j,td){
                    if(/^.*(:|\uFF1A)$/img.test($(td).text().replace(/\s/img,""))&&$(td).children().size()==0){
                        $(td)
                            .addClass("TF-Title")
                            .css({width:opts.TDTitleWidth})
                            .next()
                                .addClass("TF-Data");
                         if(/^\*.*$/img.test($(td).text())){
                            $(td).html($(td).html().replace(/^\*/img,""));
                            $(td).prepend("<font class='red'>*</font>");
                         }
                         if(opts.hiddenColon==true){
                            $(td).html($(td).html().replace(/(:|\uFF1A)$/img,""));
                         }
                    }
                    if($(td).hasClass("TF-Data")){
                        $(td).children(":input:not(:radio,:checkbox,:button)")
                             .css("height",opts.inputHeight)
                        .end()
                        .children("textarea").css({width:function(){
                            if($(this).attr("cols")!=null){return $(this).attr("size","");}
                        },height:function(){
                            if($(this).attr("rows")==null){return opts.inputHeight*2}
                            else{return opts.inputHeight*parseInt($(this).attr("rows"))}
                        }})
                        
                    }
                })
            })
            
            resizeTL=function($tf,TDTitleWidth,inputResize,inputFoceResize){
                $tf.parent().parent().css("height","");
                if(opts.width=="100%"){
                    $tf.parent().width($tf.parent().parent().width());
                    $tf.width($tf.parent().width()-2);
                }
                else{$tf.width(opts.width);}
                $tf.parent().show();
                if($("html").hasClass("IE8")||$("html").hasClass("IE7")||$("html").hasClass("IE6")){
                    $("html").css("overflow-y","");
                }else{
                    $("body").css("overflow-y","");
                }
                var $tbody=$tf.children(),
                    $tr=$tbody.children(),
                    FirstMaxRow=null;
                    RowMaxTD=0;
                var MaxRowTD=$tr.first().children().size();
                $tr.first().children().each(function(i,td){
                    if($(td).attr("colspan")){
                        MaxRowTD=MaxRowTD+parseInt($(td).attr("colspan"))-1;
                    }
                });
                
                $tr.each(function(i,tr){
                    var $td=$(tr).children();
                    if(FirstMaxRow==null&&$td.size()==MaxRowTD){FirstMaxRow=i;}
                    if($td.size()>RowMaxTD){RowMaxTD=$td.size();}
                });
                if(FirstMaxRow==null){
                    $tr.each(function(j,tr){
                        var $td=$(tr).children();
                        if(FirstMaxRow==null&&$td.size()==RowMaxTD){FirstMaxRow=j;}
                    });
                }
                
                $tr.each(function(i,tr){
                    var $td=$(tr).children("td");
                    var $tdData=$(tr).children(".TF-Data");
                    var $tdDataSize=$tdData.size();
                    if($tdDataSize>1&&i==FirstMaxRow){
                        $tdData.each(function(j,tdData){
                            if(j!=$tdDataSize-1){
                                $(tdData).width(function(){
                                    return parseInt(($tf.width()-(MaxRowTD-$tdDataSize)*TDTitleWidth)/$tdDataSize)-20;
                                });
                            }
                        });
                    }
                    $td.each(function(j,td){});
                    $tdData.each(function(j,tdData){
                        var ipt=$(tdData).children(":input:not(:radio,:checkbox,:button)")
                            ,iptSize=ipt.size();
                        var iptAttrS=ipt.attr("size"),
                            iptAttrW=ipt.attr("width"),
                            iptStyleW=ipt.attr("style");
                            //alert("1 "+iptAttrS+"2 "+iptAttrW+"3 "+iptStyleW)
                            
                        if(iptSize==1&&((inputResize==true&&$(tdData).children().size()==1&&iptAttrS==null&&(iptAttrW==null||$("html").hasClass("IE7")||$("html").hasClass("IE6"))&&iptStyleW.indexOf("width")==-1)||ipt.data("initwidth")=="true"||inputFoceResize)){
                            iptW=ipt.parent().width()-20;
                            if(iptW<50){iptW=50;}
                            ipt.width(iptW).data("initwidth","true").show();
                        }
                    });
                });
                $tf.find(".tableFormWrap").each(function(ii,TFW){
                    $(TFW).width($(TFW).parent().width());
                    $(TFW).show(0);
                })
            }
            clearTLW=function($tf,TDTitleWidth,inputResize,inputFoceResize){
                $tf.parent().parent().height($tf.parent().parent().height());
                $tf.find(".tableFormWrap").hide(0);
                $tf.parent().hide(0);
                var $tbody=$tf.children(),
                    $tr=$tbody.children();
                $tr.each(function(i,tr){
                    var $td=$(tr).children("td");
                    var $tdData=$(tr).children(".TF-Data");
                    var $tdDataSize=$tdData.size();
                    $tdData.each(function(j,tdData){
                        var ipt=$(tdData).children(":input:not(:radio,:checkbox,:button)")
                            ,iptSize=ipt.size();
                        var iptAttrS=ipt.attr("size"),
                            iptAttrW=ipt.attr("width"),
                            iptStyleW=ipt.attr("style");
                        if(iptSize==1&&((inputResize==true&&$(tdData).children().size()==1&&iptAttrS==null&&iptAttrW==null&&iptStyleW.indexOf("width")==-1)||ipt.data("initwidth")=="true"||inputFoceResize)){
                            ipt.width(10).hide();
                        }
                    });
                });
                if($("html").hasClass("IE8")||$("html").hasClass("IE7")||$("html").hasClass("IE6")){
                    if($("html").height()<$(document).height()){$("html").css("overflow-y","scroll");}
                }else{
                    if($("body").height()<$(document).height()){$("body").css("overflow-y","scroll");}
                }
                resizeTL($tf,TDTitleWidth,inputResize,inputFoceResize);
            }
            resizeTL($tf,opts.TDTitleWidth,opts.inputResize,opts.inputFoceResize);
            
            bindResize=function($tf,TDTitleWidth,inputResize,inputFoceResize){
                /*$tf.find("table").each(function(x,inTable){
                    if($(inTable).is(":visible")){
                        $(inTable).data("formlink",true).hide();
                    }
                });*/
                if(opts.width=="100%"&&$("html").hasClass("IE6")==false&&opts.autoResize==true){
                    $(window).one("resize",function(){
                        /*
                        var claSplit=$tf.attr("class").split(" "),
                            claTheOne;
                        if(claSplit.length!=1){
                            $.map(claSplit,function(n){
                                if(n!="tableForm"){claTheOne=n}
                            })
                        }else{
                            claTheOne=$tf.attr("class");
                        }
                        */
                        if($tf.is(":hidden")){bindResize($tf,opts.TDTitleWidth,opts.inputResize,opts.inputFoceResize);return;}
                        $tf.data("resizing","ture");
                        $.timer.set($tf.attr("class")+x,function(){
                            clearTLW($tf,TDTitleWidth,inputResize,inputFoceResize);
                            setTimeout(function(){bindResize($tf,TDTitleWidth,inputResize,inputFoceResize)},300)
                        },300)
                        $tf.data("resizing",null);
                    })
                }
                $tf.find("table").each(function(x,inTable){
                    if($(inTable).is(":hidden")&&$(inTable).data("formlink")==true){
                        $(inTable).wshow();
                    }
                });
                //$tf.find("table")is(":visible").data("formlink","true").hide();
            }
            bindResize($tf,opts.TDTitleWidth,opts.inputResize,opts.inputFoceResize);
        })
    }
})(jQuery);


/*!
 * jQuery Browser Plugin v0.0.6
 */

(function( jQuery, window, undefined ) {
  "use strict";
  var matched, browser;
  jQuery.uaMatch = function( ua ) {
    ua = ua.toLowerCase();
    var match = /(opr)[\/]([\w.]+)/.exec( ua ) ||
        /(chrome)[ \/]([\w.]+)/.exec( ua ) ||
        /(version)[ \/]([\w.]+).*(safari)[ \/]([\w.]+)/.exec( ua ) ||
        /(webkit)[ \/]([\w.]+)/.exec( ua ) ||
        /(opera)(?:.*version|)[ \/]([\w.]+)/.exec( ua ) ||
        /(msie) ([\w.]+)/.exec( ua ) ||
        ua.indexOf("trident") >= 0 && /(rv)(?::| )([\w.]+)/.exec( ua ) ||
        ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec( ua ) ||
        [];
    var platform_match = /(ipad)/.exec( ua ) ||
        /(iphone)/.exec( ua ) ||
        /(android)/.exec( ua ) ||
        /(windows phone)/.exec( ua ) ||
        /(win)/.exec( ua ) ||
        /(mac)/.exec( ua ) ||
        /(linux)/.exec( ua ) ||
        /(cros)/i.exec( ua ) ||
        [];
    return {
        browser: match[ 3 ] || match[ 1 ] || "",
        version: match[ 2 ] || "0",
        platform: platform_match[ 0 ] || ""
    };
  };
  matched = jQuery.uaMatch( window.navigator.userAgent );
  browser = {};
  if ( matched.browser ) {
    browser[ matched.browser ] = true;
    browser.version = matched.version;
    browser.versionNumber = parseInt(matched.version);
  }
  if ( matched.platform ) {
    browser[ matched.platform ] = true;
  }
  if ( browser.android || browser.ipad || browser.iphone || browser[ "windows phone" ] ) {
    browser.mobile = true;
  }
  if ( browser.cros || browser.mac || browser.linux || browser.win ) {
    browser.desktop = true;
  }
  if ( browser.chrome || browser.opr || browser.safari ) {
    browser.webkit = true;
  }
  if ( browser.rv )
  {
    var ie = "msie";
    matched.browser = ie;
    browser[ie] = true;
  }
  if ( browser.opr )
  {
    var opera = "opera";
    matched.browser = opera;
    browser[opera] = true;
  }
  if ( browser.safari && browser.android )
  {
    var android = "android";
    matched.browser = android;
    browser[android] = true;
  }
  browser.name = matched.browser;
  browser.platform = matched.platform;
  jQuery.browser = browser;
  var judgeBE=function(){
    if($.browser.msie){
        var bv=parseInt($.browser.version);
        if(bv==7&&navigator.appVersion.indexOf("Trident\/4.0")>0){bv=8}
        $("html").data("bv",bv);
        return "IE "+"IE"+bv;}
    else if($.browser.safari){return "safari webkit";}
    else if($.browser.chrome){return "chrome webkit";}
    else if($.browser.opera){return "opera webkit";}
    else if($.browser.mozilla){return "mozilla";}
    }
    var judgePF=function(){
        var x="";
        if($.browser.ipad){x=x+" ipad"}
        else if($.browser.iphone){x=x+" iphone"}
        else if($.browser["windows phone"]){x=x+" winphone"}
        else if($.browser.android){x=x+" android"}
        else if($.browser.win){x=x+" win"}
        else if($.browser.mac){x=x+" mac"}
        else if($.browser.linux){x=x+" linux"}
        else if($.browser.cros){x=x+" cros"}
        
        if($.browser.desktop){x=x+" desktop"}
        else if($.browser.mobile){x=x+" mobile"}
        return x;
    }
    $("html").addClass(judgeBE()+" "+judgePF()+" UIDesign&FrontEndDev—aYin86@163.com");
    //alert(judgeBE())
})( jQuery, window );


//jquery settimeout
(function($,document){
    $.timeout=function(speed,fun,obj){
        if(typeof obj.timeID!="undefined"){clearTimeout(obj.timeID);}
        obj.timeID=setTimeout(fun,speed);}
    $.clearTimeout=function(obj){if(typeof obj.timeID!="undefined"){clearTimeout(obj.timeID);}}
})(jQuery,document);

(function($,document){
$.timer = {
    data:   {}
,   set:    function(s, fn, ms){$.timer.clear(s);$.timer.data[s]=setTimeout(fn, ms);}
,   clear:  function(s){var t=$.timer.data; if(t[s]){clearTimeout(t[s]);delete t[s];}}
}
})(jQuery,document);
//jquery indexOf
(function($,document){$.indexOf=function(obj,str){if(obj.indexOf(str)>-1){return true}else{return false}}})(jQuery, document);



//jquery Cookie
(function($, document) {
    var pluses = /\+/g;
    function raw(s) {return s;}
    function decoded(s) {return decodeURIComponent(s.replace(pluses, ' '));}
    $.cookie = function(key, value, options) {
        // key and at least value given, set cookie...
        if (arguments.length > 1 && (!/Object/.test(Object.prototype.toString.call(value)) || value == null)) {
            options = $.extend({}, $.cookie.defaults, options);
            if (value == null) {options.expires = -1;}
            if (typeof options.expires === 'number') {var days = options.expires, t = options.expires = new Date();
                t.setDate(t.getDate() + days);}
            value = String(value);
            return (document.cookie = [
                encodeURIComponent(key), '=', options.raw ? value : encodeURIComponent(value),
                options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
                options.path    ? '; path=' + options.path : '',
                options.domain  ? '; domain=' + options.domain : '',
                options.secure  ? '; secure' : ''
            ].join(''));
        }
        options = value || $.cookie.defaults || {};
        var decode = options.raw ? raw : decoded;
        var cookies = document.cookie.split('; ');
        for (var i = 0, parts; (parts = cookies[i] && cookies[i].split('=')); i++) {
            if (decode(parts.shift()) === key) {return decode(parts.join('='));}}
        return null;};
    $.cookie.defaults = {};
})(jQuery,document);

/*
(function($,document){
   $.timer = {
    data:   {}
,   set:    function (s, fn, ms) { this.clear(s); this.data[s] = setTimeout(fn, ms); }
,   clear:  function (s) { if (this.data[s]) {clearTimeout(this.data[s]); delete this.data[s];} }
}
})(jQuery,document);
*/

(function($){
    $.ms=function(ms){
        if($("html").hasClass("IE6")||$("html").hasClass("IE7")||$("html").hasClass("IE8"))
        {return 0;}else{return ms;}
    }
})(jQuery);




