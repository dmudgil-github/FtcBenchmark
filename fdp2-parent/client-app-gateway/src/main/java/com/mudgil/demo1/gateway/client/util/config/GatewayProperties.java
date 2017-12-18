package com.mudgil.demo1.gateway.client.util.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties("servergateway")
public class GatewayProperties {

	@NotNull
    private List<Cluster> cluster = new ArrayList<>();
	
	@NotNull
    private AppPath appPath;

	public AppPath getAppPath() {
		return appPath;
	}

	public void setAppPath(AppPath appPath) {
		this.appPath = appPath;
	}
	
	public List<Cluster> getCluster() {
		return cluster;
	}

	public void setCluster(List<Cluster> cluster) {
		this.cluster = cluster;
	}



	public static class AppPath {
		@NotNull
	    private String appContext;

		@NotNull
	    private String apiURI;

		
		public String getAppContext() {
			return appContext;
		}

		public void setAppContext(String appContext) {
			this.appContext = appContext;
		}

		public String getApiURI() {
			return apiURI;
		}

		public void setApiURI(String apiURI) {
			this.apiURI = apiURI;
		}

		@Override
		public String toString() {
			return "AppPath [appContext=" + appContext + ", apiURI=" + apiURI + "]";
		}

		
	}
	
	   public static class Cluster {
	        private String host;
	        private int port;

	        public String getHost() {
	            return host;
	        }

	        public void setHost(String host) {
	            this.host = host;
	        }

	        public int getPort() {
	            return port;
	        }

	        public void setPort(int port) {
	            this.port = port;
	        }

	        @Override
	        public String toString() {
	            return "Cluster{" +
	                    "host='" + host + '\'' +
	                    ", port='" + port + '\'' +
	                    '}';
	        }
	    }

	@Override
	public String toString() {
		return "GatewayProperties [cluster=" + cluster + ", appPath=" + appPath + "]";
	}


}
