'use strict';
module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable('datakantor', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      idkantor: {
        type: Sequelize.STRING
      },
      namakantor: {
        type: Sequelize.STRING
      },
      alamatkantor: {
        type: Sequelize.STRING
      },
      emailkantor: {
        type: Sequelize.STRING
      },
      telepon: {
        type: Sequelize.STRING
      },
      createdAt: {
        allowNull: false,
        type: Sequelize.DATE
      },
      updatedAt: {
        allowNull: false,
        type: Sequelize.DATE
      }
    });
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('datakantor');
  }
};