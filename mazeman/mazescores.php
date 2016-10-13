<html>
<head>
  <title>jdbc hits</title>
  <link href="nav_style.css" type=text/css rel=stylesheet>

</head>
<body bgcolor = white>

<table>
<tr>
<td bgcolor = yellow><left>&nbsp;NAME&nbsp;</a></td>
<td bgcolor = yellow><left>&nbsp;MAZE NAME&nbsp;</a></td>
<td bgcolor = yellow><left>&nbsp;SCORE&nbsp;</a></td>
<td bgcolor = yellow><left>&nbsp;DATE&nbsp;</a></td>
</tr>
<?php
include 'db.php';
$connection = mysql_connect("localhost",$username,$password);
mysql_select_db("web", $connection);

$sql = "select name, score, maze, datetime from maze order by score;";
	$result = mysql_query ($sql, $connection);
	$therows = mysql_num_rows($result);

$count = 0;
$h = "<h3>";
   while ($row = mysql_fetch_row($result)) 
   { echo "<tr>";    
     for ($i=0; $i<mysql_num_fields($result); $i++){
     		$bgc = "#dddddd";
		if($count % 2 == 0)$bgc = "#eeeeee";
		echo "<td bgcolor = $bgc>";
       		echo "<h4> $row[$i]&nbsp;";
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
