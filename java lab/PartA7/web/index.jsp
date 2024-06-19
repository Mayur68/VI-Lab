<%@page import="com.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <h1>Online Shopping</h1>
        <%
            ArrayList<Item> cart;
            if (request.getSession().getAttribute("cart") == null) {
                cart = new ArrayList<Item>();
                request.getSession().setAttribute("cart", cart);
            } else {
                cart = (ArrayList<Item>) request.getSession().getAttribute("cart");

            }
        %>
        <table width="100%">
            <tr>
                <td>
                    <form method="POST">
                        <img src="images/co.png" alt="coke" height="200px"/>
                        <h4>Coke</h4>
                        <input type="hidden"value="Coke"name="name">
                        Price : Rs. 35
                        <input type="hidden"value="35"name="price">
                        <br>
                        Quantity :
                        <input type="number"value="1"name="qty" width="2"style="width:20px">
                        <br>
                        <input type="submit"value="Add"name="addBtn">
                    </form>
                </td>
                <td>
                    <form method="POST">
                        <img src="images/co.png" alt="Dew" height="200px"/>

                        <h4>Dew</h4>
                        <input type="hidden"value="Dew"name="name">
                        Price : Rs. 34
                        <input type="hidden"value="34"name="price">
                        <br>
                        Quantity :
                        <input type="number"value="1"name="qty" width="2"style="width:20px">
                        <br>
                        <input type="submit"value="Add"name="addBtn">
                    </form>
                </td>
                <td>
                    <form method="POST">
                        <img src="images/co.png" alt="Pepsi" height="200px"/>
                        <h4>Pepsi</h4>
                        <input type="hidden"value="Pepsi"name="name">
                        Price : Rs. 36
                        <input type="hidden"value="36"name="price">
                        <br>
                        Quantity :
                        <input type="number"value="1"name="qty" width="2"style="width:20px">
                        <br>
                        <input type="submit"value="Add"name="addBtn">
                    </form>
                </td>
                <td>
                    <form method="POST">
                        <img src="images/co.png" alt="Thumps up"height="200px"/>
                        <h4>Thumps up</h4>
                        <input type="hidden"value="Thumps up"name="name">
                        Price : Rs. 28
                        <input type="hidden"value="28"name="price">
                        <br>
                        Quantity :
                        <input type="number"value="1"name="qty" width="2"style="width:20px">
                        <br>
                        <input type="submit"value="Add"name="addBtn">
                    </form>
                </td>


            </tr>

        </table>

        <%
            if (request.getParameter("removeBtn") != null) {
                int index = Integer.parseInt(request.getParameter("ino"));
                cart.remove(index);
                out.println("<h4 style=\"color: green\"> Item is removed</h4>");
            }

            if (request.getParameter("addBtn") != null) {
                int qty = Integer.parseInt(request.getParameter("qty"));
                if (qty < 0) {
                    out.println("<h4 style=\"color: red\"> Please enter a positive value for quantity</h4>");
                } else {
                    String name = request.getParameter("name");
                    boolean ItemFound = false;
                    for (int i = 0; i < cart.size(); i++) {
                        Item item = cart.get(i);
                        if (item.getName().equals(name)) {
                            item.setQty(item.getQty() + qty);
                            out.println("<h4 style=\"color: blue\"> Item:" + name + " added to the cart</h4>");
                            ItemFound = true;
                            break;
                        }
                    }
                    if (!ItemFound) {
                        double price = Double.parseDouble(request.getParameter("price"));
                        Item itm = new Item(name, qty, price);
                        cart.add(itm);
                        out.println("<h4 style=\"color: blue\"> Item:" + name + " added to the cart</h4>");
                    }
                }
            }
            if (cart.size() > 0) {

            }
        %>
        <h2>Cart Details</h2>
        <table border="2">
            <tr>
                <th>Item Name </th>
                <th>Quantity</th>
                <th>Unit Price </th>
                <th>Total</th>
                <th>Action</th>
            </tr>
            <%
                for (int i = 0; i < cart.size(); i++) {
                    Item item = cart.get(i);
            %>
            <tr>
                <td><%= item.getName()%></td>
                <td><%= item.getQty()%></td>
                <td><%= item.getPrice()%></td>
                <td><%= item.getQty() * item.getPrice()%></td>
                <td>
                    <form method="POST">
                        <input type="hidden" value="<%= i%>" name="ino">
                        <input type="submit" value="remove" name="removeBtn">
                    </form>
                </td>
            </tr>
            <% }%>

        </table>

    </body>
</html>