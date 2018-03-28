'use strict';
module.exports = (sequelize, DataTypes) => {
  var datakaryawan = sequelize.define('datakaryawan', {
    nik: DataTypes.STRING,
    nama: DataTypes.STRING,
    alamat: DataTypes.STRING,
    tgl_lahir: DataTypes.DATE,
    status: DataTypes.STRING,
    email: DataTypes.STRING,
    tgl_masuk: DataTypes.DATE,
    status: DataTypes.STRING,
    jabatan: DataTypes.STRING,
    photo: DataTypes.BLOB
  }, {});
  datakaryawan.associate = function(models) {
    // associations can be defined here
  };
  return datakaryawan;
};