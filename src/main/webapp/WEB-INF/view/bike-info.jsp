<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2> Bike info</h2>
<br>
<form:form action="saveBike" modelAttribute="bike">

    <form:hidden path="id"/>
    <form:hidden path="price"/>

    Product name: <br>
    Silex200 <form:radiobutton path="productName" value="Silex200"/> <br>
    Silex400 <form:radiobutton path="productName" value="Silex400"/> <br>
    Silex600 <form:radiobutton path="productName" value="Silex600"/> <br>
    <form:errors path="productName"/>
    <br><br>

    Color <form:select path="color">
    <form:option value="orange" label="orange"/>
    <form:option value="blue" label="blue"/>
    <form:option value="black" label="black"/>
</form:select>
    <br><br>

    Frame size <form:select path="frameSize">
    <form:option value="S" label="S"/>
    <form:option value="M" label="M"/>
    <form:option value="L" label="L"/>
</form:select>
    <br><br>

<%--    Item per <form:input path="itemPer"/>--%>
    <br><br>

    <input type="submit" value="OK"/>
    <br><br>
</form:form>


<input type = "button" value="BASKET"
       onclick="window.location.href = 'basket'"/>
</body>

</html>