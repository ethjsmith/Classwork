
public class Chapter5Problem44Strings {

	public static void main(String[] args) {

	}

	//TODO List the BigOh Runtime Here:
	public static String makeLongString1( int N )
	{
		String result = "";
		for( int i = 0; i < N; i++ )
			result += "x";
		return result;
	}

	//TODO List the BigOh Runtime Here:
	public static String makeLongString2( int N )
	{
		StringBuilder result = new StringBuilder( "" );
		for( int i = 0; i < N; i++ )
			result.append( "x" );
		return new String( result );
	}

}
