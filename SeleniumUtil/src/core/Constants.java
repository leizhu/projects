package core;

import java.io.File;

//import org.apache.bcel.classfile.Constant;
//
//import net.cetas.qa.ui.automation.configurationreader.ConfigurationReader;
public class Constants
{
	//private static Logger logger = LoggerHandler.getLoggerHandlerInstance().getCurrentLogger();//Logger.getLogger("DEFAULT_LOGGER");
	
	/**
	 * Following constants are general in this package
	 */
	public static final int	SUCCESS 		= 0;
	public static final int	FAILURE 		= -1;
	public static final int	ZERO    		= 0;
	public static final int	ONE		 		= 1;
	public static final int	TWO     		= 2;
	public static final int	THREE    		= 3;
	public static final int	MINUS_ONE		= -1;
	public static final int	MINUS_TWO   	= -2;
	public static final int	MINUS_THREE 	= -3;
	public static final char CHR_YES        = 'y';
	public static final char CHR_NO        	= 'n';
	public static final char SPACE         	= ' ';
	public static final String STR_YES      = "y";
	public static final String STR_NO     	= "n";
	public static final String STR_SPACE  	= " ";
	public static final String STR_HASH  	= "#";
	public static final String STR_EQUAL	= "=";
	public static final String STR_ERROR  	= "Error:";
	public static final String STR_SEMICOLON= ";";
	public static final String STR_COLON	= ":";
	public static final String STR_HYPHEN	= "-";
	public static final String CONF_COMMENT = STR_HASH;
	
	
	/*
	 * Following constants char as STRING
	 */
	public static final String EMPTY_STRING		= "";
	public static final String EQUALTO			= "=";
	public static final String DOUBLE_QUOTE     = "\"";
	public static final String TRIPLE_TAB  		= "\t\t\t";
	public static final String DOUBLE_TAB  		= "\t\t";
	public static final String SINGLE_TAB  		= "\t";
	public static final String UNIX_NEWLINE		= "\r\n";
	public static final String WIN_NEWLINE 		= "\n";
	public static final String STR_BACKSLASH 	= "\\";
	public static final char CHR_NEWLINE	 = '\n';
	public static final char CHR_TAB		 = '\t';
	public static final char CHR_SPACE		 = ' ';
	public static final char CHR_ENTER 	= '\r';
	
	
	// default wait time
	public static final int WAIT_PERIOD			= 30000;
	public static final int TIMEOUT_SECONDS = 5;
	public static final long TIMEOUT_MILLIS = 15000;
	public static final long TIMEOUT_MILLIS_SHORT = 5000;
	public static final long TIMEOUT_SECONDS_IMPLICIT = 30;
	public static final long TIMEOUT_MILLIS_2_SECONDS = 2000;
	// AppLogger constants 
	
	public static final String OS_ALL	= "all";
	public static final String OS_WIN	= "windows";
	public static final String OS_UNIX	= "unix";
	public static final String WINDOWS_SHELL= "cmd /c ";
	public static final String UNIX_SHELL	= "sh -a ";
	public static final String WIN_COPY		= "copy";
	public static final String UNIX_COPY	= "cp";
	public static final String TAR_COMMAND	= "tar -cvf ";
	public static final String TAR_EXTENTION	= ".tar";
	public static final String CHANGE_DIRECTORY	= "cd ";
	public static final String ALL_OS_GETPROPERTY_PARAM 	= "os.name";
	public static final String ALL_NEWLINE_GETPROPERTY_PARAM		= "line.seperator";
	public static final String CURR_DIRECTORY			= ".";
	public static final String BACK_DIRECTORY			= "..";
	public static final String TEMP_DIRECTORY			= "tmp";
	public static final String LOG_DIRECTORY			= "log";
	public static final String REPORT_DIRECTORY			= "report";
	public static final String PACKAGE_DIRECTORY		= "package";
	public static final String RESOURCE_DIRECTORY		= "resources";
	public static final String CONF_DIRECTORY			= "conf";
	public static final String UTILS_DIRECTORY			= "tools";
	public static final String GUI_DIRECTORY			= "gui";
	public static final String DU_DIRECTORY				= "DU";
	public static final String PARENT_DIRECTORY			= "..";
	public static final String FILETYPE_XML				= "xml";
	public static final String UNIX_SRICPT_EXTENSION	= ".sh";
	public static final String WIN_SRICPT_EXTENSION		= ".bat";
	public static final String REPORT_EXTENSION 		= ".txt";
	public static final String REPORT_XML_EXTENSION 		= ".xml";
	public static final String ECHO_OFF				= "@echo off";
	public static final String TEMP_CMD_FILEPATH			= TEMP_DIRECTORY;
//	public static final String XML_FULLFILENAME 			= RESOURCE_DIRECTORY + File.separator + "DiagnosticUtil.xml";
	//public static final String DU_LOG_PROPERTY_FILE			= ".."+File.separator+ Constants.LOG_DIRECTORY + File.separator + "du_logger.properties";
	public static final String DU_LOG_PROPERTY_FILE	= Constants.RESOURCE_DIRECTORY + File.separator + "du_logger.properties";
	public static final String DEFAULT_TEXT_REPORT_FILEPATH = Constants.REPORT_DIRECTORY ;
	public static final String DEFAULT_GLOBALDATA_FILEPATH = Constants.RESOURCE_DIRECTORY ;
	public static final String GLOBAL_DATA_FILE =  DEFAULT_GLOBALDATA_FILEPATH + File.separator + "Global_Data.xml" ;
	public static final String I18N_RESOURCE_STRING_FILE	= RESOURCE_DIRECTORY + File.separator + "du_messages";
	public static final String DTD_FILENAME 				= "TH_XMLFormat.dtd";
	
	 // Timeout tools
	
	public static final int CMD_OUTPUT_READ_TIMEOUT		= 3 * 60 * 1000; 	//3 min
	public static final int CMD_ERROR_READ_TIMEOUT		= 1 * 15 * 1000; 	//15 sec
	public static final int CMD_OUTPUT_READ_READY_SLEEP	= 1 * 200;			//200 msec
	public static final int THREADPOOL_WAIT				= 1 * 3  * 1000;	//3 sec
	public static final int THREADPOOL_WAIT_MIN			= 1 * 200;			//200 msec

	
	public static final String FORWORD_SLASH					= "/";
	public static final String STR_URLSPACE  			= "%20";
	
	
	
	public static final String AUTOCONFIG  			= "resources/AutoConfig.xml";
	public static  enum PLOTAS {DIMENTION ,MEASURE };
	
	public static enum BROWSERTYPE {
	    FIREFOX, IE, CHROME, HTMLUNIT , SAFARI    ; 
	}
}

