package com.ulic.ulweb.ulweb2.service.convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;

public class ByteArrayDataSource implements DataSource {
    /** * Data to write. */
    private byte[] _data;
    
    private String name = "dummy";

    /** * Content-Type. */
    private String _type;

    /* Create a datasource from an input stream */
    public ByteArrayDataSource(InputStream is, String type) {
        _type = type;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int ch;

            // XXX : must be made more efficient by
            // doing buffered reads, rather than one byte reads
            while ((ch = is.read()) != -1)
                os.write(ch);
            _data = os.toByteArray();
             is.close();
        } catch (IOException ioe) {
        }
    }
    public ByteArrayDataSource(ByteArrayOutputStream os, String type){
    	
    	_type = type;
    	_data = os.toByteArray();
    }
 
    /* Create a datasource from a byte array */
    public ByteArrayDataSource(byte[] data, String type) {
        _data = data;
        _type = type;
    }

    /* Create a datasource from a String */
    public ByteArrayDataSource(String data, String type) {
        try {
            // Assumption that the string contains only ascii
            // characters ! Else just pass in a charset into this
            // constructor and use it in getBytes()
            _data = data.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException uee) {
        }
        _type = type;
    }

    public InputStream getInputStream() throws IOException {
        if (_data == null)
            throw new IOException("no data");
        return new ByteArrayInputStream(_data);
    }

    public OutputStream getOutputStream() throws IOException {
        throw new IOException("cannot do this");
    }

    public String getContentType() {
        return _type;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }

}
