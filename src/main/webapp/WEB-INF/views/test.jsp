<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>Test</title>
		
 		<!-- DataTables CSS -->
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.css">
		
 		<!-- jQuery -->
		<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		
 		<!-- DataTables -->
		<script type="text/javascript" src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.js"></script>
		
		<script type="text/javascript">
		$(document).ready(function() {
		    $('#example').dataTable( {
		        "processing": true,
		        "serverSide": true,
		        "ajax": { 
		        	url: "test/getAll",
		        	type: "POST"
		        }
		    } );
		} );
		</script>
	</head>
	<body>
		<div class="container">
			<table id="example" class="display">
				<thead>
					<tr>
						<th>ID</th>
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>