<?php
mysql_connect("localhost","root","");
mysql_select_db("db_siswabaru");

$sql=("select tb_calon_siswa.id_calonsiswa,tb_asal_sekolah.nama_sekolah,tb_staff.nama_staff,tb_jurusan.nama_jurusan, ");
	$sql.=("tb_calon_siswa.nama,tb_calon_siswa.nisn,tb_calon_siswa.nik,tb_calon_siswa.alamat,tb_calon_siswa.jk,  ");
	$sql.=("tb_calon_siswa.no_telp,tb_calon_siswa.nama_wali ");
	$sql.=("from tb_calon_siswa inner join tb_staff using(id_staff) inner join tb_jurusan using(kode_jurusan) inner join tb_asal_sekolah using(id_sekolah) ");
	$execute=mysql_query($sql);
	while($row=mysql_fetch_assoc($execute))
	$output[]=$row;
	print(json_encode($output));
	mysql_close();
?>