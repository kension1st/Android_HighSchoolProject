<?php

extract($_REQUEST, EXTR_OVERWRITE);
mysql_connect("localhost","root","");
mysql_select_db("db_siswabaru");

$sql=mysql_query("SELECT tb_calon_siswa.id_calonsiswa,tb_asal_sekolah.nama_sekolah,tb_staff.nama_staff,tb_jurusan.nama_jurusan,tb_calon_siswa.nama,tb_calon_siswa.nisn,tb_calon_siswa.nik,tb_calon_siswa.alamat,tb_calon_siswa.jk,tb_calon_siswa.no_telp,tb_calon_siswa.nama_wali FROM tb_calon_siswa INNER JOIN tb_staff USING(id_staff) INNER JOIN tb_jurusan USING(kode_jurusan) INNER JOIN tb_asal_sekolah USING(id_sekolah) WHERE id_sekolah=$id");
	while($row=mysql_fetch_assoc($sql))
	$output[]=$row;
	print(json_encode($output));
	mysql_close();
?>