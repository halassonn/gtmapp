'use strict';
module.exports = (sequelize, DataTypes) => {
  var datakantor = sequelize.define('datakantor', {
    idkantor: DataTypes.STRING,
    namakantor: DataTypes.STRING,
    alamatkantor: DataTypes.STRING,
    emailkantor: DataTypes.STRING,
    telepon: DataTypes.STRING
  }, {});
  datakantor.associate = function(models) {
    // associations can be defined here
  };
  return datakantor;
};