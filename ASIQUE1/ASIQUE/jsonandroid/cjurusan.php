<?php
extract($_REQUEST, EXTR_OVERWRITE);
mysql_connect("localhost","root","");
mysql_select_db("db_siswabaru");
$sql=mysql_query("select * from tb_jurusan where nama_jurusan like '%$nama%'");

	while($row=mysql_fetch_assoc($sql))
	$output[]=$row;
	
	print(json_encode($output));
	mysql_close()
?>