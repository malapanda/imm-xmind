<!DOCTYPE html>
<html>
	<head>
		<title>Impressive Mind Maps</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<link href="styles2.css" rel="stylesheet" /> 
		<script src="jquery-1.11.2.min.js"></script>
		<script src="opentip-jquery.min.js"></script>
		<link href="opentip.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<a href="index.html">Load mind map</a>
		<div id="impress">
			<div class="no-support-message">
			Your browser doesn't support impress.js.  Try Chrome or Safari.
			</div>
<#list nodesInOrder as node>
			<div id="${node.id}" class="druga step"<#if node.color??> style="background-color: ${node.color}"</#if><#if node.content.notes??> data-ot="${node.content.notes}" data-ot-style="dark"</#if> data-x="${node.coordinates.x?c}" data-y="${node.coordinates.y?c}" data-z="${node.coordinates.z?c}" data-scale="${node.scale}" data-rotate-x="${node.rotation.x?c}"<#if node.parent??> data-parent="${node.parent.id}"</#if>><div>${node.content}</div><#if node.content.image??><img src="${node.content.image.path}"></img></#if></div>
</#list>  
		</div>      
		<script type="text/javascript" src="impress.js"></script>
		<!--
			call `impress().init()` function to initialize impress.js presentation.
		-->
		<script>impress().init();</script>
	</body>
</html>
