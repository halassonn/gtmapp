'use strict';
module.exports = (sequelize, DataTypes) => {
  var datauser = sequelize.define('datauser', {
    firstname: DataTypes.STRING,
    lastname: DataTypes.STRING,
    username: {type:DataTypes.STRING,unique:true,validate:{isExist:{msg:"Username alredy taken"}}},
    email: {
      type: Sequelize.STRING,
      allowNull:true,
      unique:true,
      validate:{isEmail:{msg:"Email invalid"}}
    },
    password:  {
      type: Sequelize.STRING,
      validate:{len:{args:[7,20],msg:"password min 7 character"}}
    },
    aktif: DataTypes.BOOLEAN,
    kode_resetpwd: DataTypes.STRING
  }, {});
  datauser.associate = function(models) {
    // associations can be defined here
  };
  return datauser;
};