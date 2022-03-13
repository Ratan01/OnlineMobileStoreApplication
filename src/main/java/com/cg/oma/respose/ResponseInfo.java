package com.cg.oma.respose;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResponseInfo {
	private int status;
    private String acknowledgement;
    private String message;
    private String path;
    /**
     *   Parameterize constructor for response info 
     */
	public ResponseInfo(int status, String acknowledgement, String message, String path) {
		super();
		this.status = status;
		this.acknowledgement = acknowledgement;
		this.message = message;
		this.path = path;
	}
	/**
     *   default Parameterize constructor for response info 
     */
	public ResponseInfo() {
		super();
	}
}
