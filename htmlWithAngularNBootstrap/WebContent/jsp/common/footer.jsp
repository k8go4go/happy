<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<footer class="text-muted">
			    <p class="float-right">
			      <a href="#">Back to top</a>
			    </p>
			    <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
			    <p>New to Bootstrap? <a href="#">Visit the homepage</a> or read our <a href="#">getting started guide</a>.</p>
			</footer>
		</div>
	<div class="col-md-1"></div>
	</div>
</div>
	
<script type="text/javascript" src="${contextPath}/resources/js/bootstrap.js"></script>
<script>
$( document ).ready(function() {
    var result = '${requestScope.result}';
    var msg = '${requestScope.msg}';
    console.log(result);
    console.log(msg);
    if(result.length > 0) {
    	if(result > 0)
    		swal("처리결과", msg, "success");
    	else
    		swal("처리결과", msg, "error");
    }
});
</script>
</body>
</html>