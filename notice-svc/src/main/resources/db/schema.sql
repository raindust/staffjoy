CREATE TABLE IF NOT EXISTS notice (
                                     id VARCHAR(255),
                                     toaddr VARCHAR(255) NOT NULL,
                                     name VARCHAR(255) NOT NULL default '',
                                     subject VARCHAR(255) NOT NULL,
                                     content VARCHAR(1000) NOT NULL,
                                     PRIMARY KEY (id)
) ENGINE=InnoDB;