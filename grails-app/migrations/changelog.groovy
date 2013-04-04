databaseChangeLog = {

	changeSet(author: "guadagnj (generated)", id: "1362353694461-1") {
		createTable(tableName: "ALBUM") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_3")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "TITLE", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "guadagnj (generated)", id: "1362353694461-2") {
		createTable(tableName: "SONG") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_2")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "ALBUM_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "ARTIST", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "TITLE", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "guadagnj (generated)", id: "1362353694461-3") {
		createTable(tableName: "STORE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_4")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "guadagnj (generated)", id: "1362353694461-4") {
		addForeignKeyConstraint(baseColumnNames: "ALBUM_ID", baseTableName: "SONG", baseTableSchemaName: "PUBLIC", constraintName: "FK35F5159073478D", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "ALBUM", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}
}
