<%@ include file="Header.jsp"%>
<br>
<br>
<br>
<%-- <c:choose>
	<c:when test="${!empty mycartList}">
MY CART<br>
		<table class="table table-hover">

			<tr style="background-color: #D8D4D4">
				<th>Cart ID</th>
				<th>Grand Total</th>
				<th>Quantity</th>
				<th>User ID</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${mycartList}" var="cart">
				<tr>
					<td>${cart.cartid}</td>
					<td>${cart.grandtotal}</td>
					<td>${cart.quantity}</td>
					<td>${cart.user_userid}</td>
					<td><a href="<c:url value='cartupdate${cartid}'/>"><span
							class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="<c:url value='cartitemdelete${cartid}'/>"><span
							class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="checkout">checkout</a>
	</c:when>
	<c:otherwise>
No Products in your Cart
</c:otherwise>
</c:choose>

<%@ include file="Footer.jsp"%>
 --%>

<%-- <%@include file="Header.jsp"%>

<script>
$(document).ready(function(){
	 var path="http://localhost:8080/ECommerceFrontEnd/resources/images/";
	 
 $("#carttable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8080/ECommerceFrontEnd/allcartitems",
		    "dataSrc": ""
		  }, 
	  "columns": [
         { "data": "cartid" },
         
         { "data": "",
       	"render":function(data,type,row)
       	{
       	  return "&#8360;."+row.grandtotal+"";
         }  
         
         },
         { "data":"quantity" },
         
          
         {"data":"cartid",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8080/ECommerceFrontEnd/"+row.cartid+"/Cart' class='btn btn-primary'>View</a>";
       	  }
         }/* ,
       	
        {"data":"",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8080/ECommerceFrontEnd/"+row.product_id+"/addcart' class='btn btn-primary'>Add to cart</a>";
       	  }
         }   */
                   
     ]
 });
   
   
});
</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="carttable">
				<thead>
					<tr>
						<th>Cart Id</th>
						<th>Grand Total </th>
						<th>Quantity</th>
						<th></th>
						<th></th>
						<th></th>
						
					</tr>
				</thead>
							</table>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%> --%>