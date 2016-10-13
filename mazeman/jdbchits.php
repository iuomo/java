<html>
<head>
  <title>jdbc hits</title>
  <link href="nav_style.css" type=text/css rel=stylesheet>

</head>
<body bgcolor = white>

<table>
<tr><td bgcolor = yellow><h1><left>&nbsp;ID&nbsp;</a></td>
<td bgcolor = yellow><h1><left>&nbsp;IP&nbsp;</a></td>
<td bgcolor = yellow><h1><left>&nbsp;DATE&nbsp;</a></td>

</tr>
<?php
include 'db.php';
$connection = mysql_connect("localhost",$username,$password);
mysql_select_db("web", $connection);

$sql = "select * from maze;";
	$result = mysql_query ($sql, $connection);
	$therows = mysql_num_rows($result);

$count = 0;
$h = "<h3>";
   while ($row = mysql_fetch_row($result)) 
   { echo "<tr>";    
     for ($i=0; $i<mysql_num_fields($result); $i++){
     		echo "<td bgcolor = lightgray>";
		$h = "<h2>";
		if($count % 2 == 0)$h = "<h3>";
		//if ($i == 0)$h = "<h1>";
		//if ($i == 6)$h = "<h1>";
       		echo "$h$row[$i]&nbsp;";
   		echo "</td>";
	}
          echo "</tr>";
	  $count++;
   }

   mysql_close($connection);
  echo "</table>";	
?>

<br>
<h1>
</body>
</html>  
