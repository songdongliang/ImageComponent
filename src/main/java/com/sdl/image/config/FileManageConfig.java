package com.sdl.image.config;

import java.io.Serializable;

public interface FileManageConfig extends Serializable{

    String FILE_DEFAULT_AUTHOR = "songdongliang";

    String PROTOCOL = "http://";

    String SEPARATOR = "/";

    String TRACKER_NGNIX_ADDR = "192.168.42.128";

    String TRACKER_NGNIX_PORT = "";

    String CLIENT_CONFIG_FILE = "fdfs_client.properties";
}
