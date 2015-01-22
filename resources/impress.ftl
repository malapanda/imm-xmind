<!doctype html>
<html>
	<head>
		<title>Impressive Mind Maps</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<link href="styles2.css" rel="stylesheet" /> 
	</head>
	<body>
		<div id="impress">
			<div class="no-support-message">
			Your browser doesn't support impress.js.  Try Chrome or Safari.
			</div>
<#list nodesInOrder as node>
			<div id="${node.id}" class="druga step" data-x="${node.coordinates.x?c}" data-y="${node.coordinates.y?c}" data-z="${node.coordinates.z?c}" data-scale="${node.scale}" data-rotate-x="${node.rotation.x?c}"<#if node.parent??> data-parent="${node.parent.id}"</#if>>${node.content}</div>
</#list>  
		</div>      
		<script type="text/javascript" src="impress.js"></script>
		<!--
			call `impress().init()` function to initialize impress.js presentation.
		-->
		<script>impress().init();</script>
	</body>
</html>
