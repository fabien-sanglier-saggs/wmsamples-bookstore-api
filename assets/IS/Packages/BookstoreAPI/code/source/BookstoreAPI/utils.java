package BookstoreAPI;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void objectToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(objectToString)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inObject
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object obj = IDataUtil.get(pipelineCursor, "inObject");
		pipelineCursor.destroy();
		
		// return pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outString", 	(null != obj)?obj.toString():"" );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void parseDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required inPattern
		// [i] field:0:required inLocaleLanguageTag
		// [o] object:0:required outDate
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getNonEmptyString(pipelineCursor, "inString");
		String inPattern = IDataUtil.getString(pipelineCursor, "inPattern");
		String inLocaleLanguageTag = IDataUtil.getString(pipelineCursor, "inLocaleLanguageTag");
		pipelineCursor.destroy();
		
		SimpleDateFormat dFormatter = null;
		if(null == inPattern) {
			dFormatter = new SimpleDateFormat();
		} else {
			if(null != inLocaleLanguageTag && ! "".equals(inLocaleLanguageTag))
				dFormatter = new SimpleDateFormat(inPattern, Locale.forLanguageTag(inLocaleLanguageTag));
			else
				dFormatter = new SimpleDateFormat(inPattern);
		}
		
		Date outDate = null;
		if(null != inString && ! "".equals(inString)){
			try{
				outDate = dFormatter.parse(inString);
			} catch(ParseException pe){
				outDate = null;
				throw new ServiceException(pe);
			}
		}
		
		// return pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outDate", outDate );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void parseFloat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseFloat)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] object:0:required outNumber
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getNonEmptyString(pipelineCursor, "inString");
		pipelineCursor.destroy();
		
		Float outNumber = null;
		if(null != inString && ! "".equals(inString)){
			try{
				outNumber = Float.parseFloat(inString);
			} catch(NumberFormatException nfe){
				outNumber = null;
				throw new ServiceException(nfe);
			}
		}
		
		// return pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outNumber", outNumber );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void parseInteger (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseInteger)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] object:0:required outNumber
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getNonEmptyString(pipelineCursor, "inString");
		pipelineCursor.destroy();
		
		Integer outNumber = null;
		if(null != inString && ! "".equals(inString)){
			try{
				outNumber = Integer.parseInt(inString);
			} catch(NumberFormatException nfe){
				outNumber = null;
				throw new ServiceException(nfe);
			}
		}
		
		// return pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outNumber", outNumber );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void parseShort (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseShort)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] object:0:required outNumber
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getNonEmptyString(pipelineCursor, "inString");
		pipelineCursor.destroy();
		
		Short outNumber = null;
		if(null != inString && ! "".equals(inString)){
			try{
				outNumber = Short.parseShort(inString);
			} catch(NumberFormatException nfe){
				outNumber = null;
				throw new ServiceException(nfe);
			}
		}
		
		// return pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outNumber", outNumber );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

