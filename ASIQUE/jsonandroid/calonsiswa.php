<?php

mysql_connect("localhost","root","");
mysql_select_db("db_siswabaru");
$sql=mysql_query("select tb_calon_siswa.*,tb_jurusan.*,tb_asal_sekolah.* from tb_calon_siswa inner join tb_jurusan using(kode_jurusan)\n"
    . "	inner join tb_asal_sekolah using(id_sekolah)");

	while($row=mysql_fetch_assoc($sql))
	$output[]=$row;
	
	print(json_encode($output));
	mysql_close()
?>