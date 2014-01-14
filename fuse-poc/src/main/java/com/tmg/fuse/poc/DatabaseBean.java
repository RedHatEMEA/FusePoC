/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tmg.fuse.poc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.sql.DataSource;

import org.apache.camel.util.IOHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseBean {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseBean.class);
    private DataSource dataSource;
    private String location;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void create() throws Exception {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        // TODO: load sql from classpath (can be tricky in OSGi)
        String sql = "CREATE TABLE account( ID INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(100) DEFAULT NULL, XREFID INT DEFAULT NULL, CRMID INT DEFAULT NULL, PSPID INT DEFAULT NULL )";
        String sql2 = "CREATE SEQUENCE seq_xrefId START WITH 10000";
        String sql3 = "INSERT INTO account (NAME, XREFID, CRMID) VALUES ('Jon Walton',1234, 100)";
        String sql4 = "INSERT INTO account (NAME, XREFID, CRMID) VALUES ('Graeme Colman',5678, 200)";

        LOG.info("Creating table account ...");

        try {
            jdbc.execute("drop table account");
        } catch (Throwable e) {
            // ignore
        }

        jdbc.execute(sql);
        jdbc.execute(sql2);
        jdbc.execute(sql3);
        jdbc.execute(sql4);

        LOG.info("... created table account");
    }

    public void destroy() throws Exception {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        try {
            jdbc.execute("drop table account");
        } catch (Throwable e) {
            // ignore
        }

        try {
            jdbc.execute("drop sequence seq_xrefId");
        } catch (Throwable e) {
            // ignore
        }
    }

}
