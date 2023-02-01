<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<h2>All bikes</h2>
<br>

<table>
    <tr>
        <th>Product name</th>
        <th>Color</th>
        <th>Frame size</th>
        <th>Price, $</th>
        <th>Operators</th>
    </tr>

    <c:forEach var = "b" items="${allB}">

        <c:url var="updateButton" value="updateInfo">
            <c:param name="bikeId" value="${b.id}"/>
        </c:url>

        <c:url var="deleteButton" value="deleteBike">
            <c:param name="bikeId" value="${b.id}"/>
        </c:url>

        <tr>
            <td>${b.productName}</td>
            <td>${b.color}</td>
            <td>${b.frameSize}</td>
            <td>${b.price}</td>

            <td>
                <input type="button" value="UPDATE"
                onclick="window.location.href='${updateButton}'"/>

                <input type="button" value="DELETE"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>

        </tr>


    </c:forEach>
</table>

<br>
<input type = "button" value="Add"
onclick="window.location.href = 'addNewBike'"/>


</html>