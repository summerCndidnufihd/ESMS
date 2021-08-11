/**
 * 搜索框
 */
function searchName(){
        //div的属性名为  content
        var div=document.getElementByIdx_x("content");
        div.innerHTML=" ";
        //获取用户输入的值
        var name=document.getElementByIdx_x("name").value;
        //如果用户输入为null，不执行代码
        if(name==null||name==""){
         return;
        }
        //发送请求，异步的方式
        //穿建对象
        var xhr=createXMLHttpRequest();
        //连接资源
        xhr.open("POST","searchServlet",true);
        //设置请求头
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        //发送请求之前，设置请求头
        xhr.send("name="+name);
        //监听
        xhr.onreadystatechange=function(){
         if(xhr.readyState==4&&xhr.status==200){
           //接收数据
           var result=xhr.responseText;
           //切割字符串
           var names=result.split(",");
           for(var i=0;i<name.length();i++){
            //获取到每一个名称
            var name=names[i];
            //显示到div中间
             div.innerHTML+=""+name+"";
           }
           
         }
        };
        //显示
        div.style.display="block";
       }
     //把鼠标移动到该元素上，显示颜色
       function overColor(who){
       //改变当前div的背景颜色
      who.style.backgroundColor="green";
       }
       //从当前的元素上移开，改变背景颜色
       function outColor(who){
      who.style.backgroundColor="white";
       }
       
       //用户点击了某个值，把这个值赋值到文本框中
       function setValue(val){
       var name=document.getElementByIdx_x("name");
      name.value=val;
       //让框隐藏
      var div=document.getElementByIdx_x("content");
      div.style.display="none";
       }
       
    // 创建XMLHttpRequest对象
     function createXMLHttpRequest(){
      try {
        // 如果是你是IE高版本  火狐 谷歌
        return new XMLHttpRequest();
      } catch (e) {
        try {
         // 如果是IE6的版本
         return new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
         try {
           // 如果是IE5.5版本
           return new ActiveXObject("Microsoft.XMLHTTP");
         } catch (e) {
           alert("您这是什么浏览器呀！！");
         }
        }
      }
     }
 