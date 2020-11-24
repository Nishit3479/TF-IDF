package ir.token3.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TFIDF 
{
    public double tf(List<String> doc, String term) 
    {
        double result = 0;
        for (String word : doc) 
        {
            if (term.equalsIgnoreCase(word))
            {
                result++;
            }
        }
        return result / doc.size();
    }
    public double idf(List<List<String>> docs, String term) 
    {
        double n = 0;
        for (List<String> doc : docs) 
        {
            for (String word : doc) 
            {
                if (term.equalsIgnoreCase(word)) 
                {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) 
    {
        return tf(doc, term) * idf(docs, term);
    }

    public static void main(String[] args) 
    {
    	String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		String data5 = "";
		try { 
			data1 = new String(Files.readAllBytes(Paths.get("test1.txt")));
			data2 = new String(Files.readAllBytes(Paths.get("test2.txt")));
			data3 = new String(Files.readAllBytes(Paths.get("test3.txt")));
			data4 = new String(Files.readAllBytes(Paths.get("test4.txt")));
			data5 = new String(Files.readAllBytes(Paths.get("test5.txt")));
			} 	
		catch (IOException e) { 
			e.printStackTrace(); 
			}
		String str1 = data1.toLowerCase();
		String St1="";
		for(int i=0; i<str1.length(); i++)
		{
			char p = str1.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St1 +=" "+p;
			}
			else
			{
				St1 += p;
			}
		}
		String []token1 = St1.split(" ");
		
		String str2 = data2.toLowerCase();
		String St2="";
		for(int i=0; i<str2.length(); i++)
		{
			char p = str2.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St2 +=" "+p;
			}
			else
			{
				St2 += p;
			}
		}
		String []token2 = St2.split(" ");
		
		String str3 = data3.toLowerCase();
		String St3 = "";
		for(int i=0; i<str3.length(); i++)
		{
			char p = str3.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St3 +=" "+p;
			}
			else
			{
				St3 += p;
			}
		}
		String []token3 = St3.split(" ");
		
		String str4 = data4.toLowerCase();
		String St4="";
		for(int i=0; i<str4.length(); i++)
		{
			char p = str4.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St4 +=" "+p;
			}
			else
			{
				St4 += p;
			}
		}
		String []token4 = St4.split(" ");
		
		String str5 = data5.toLowerCase();
		String St5="";
		for(int i=0; i<str5.length(); i++)
		{
			char p = str5.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St5 +=" "+p;
			}
			else
			{
				St5 += p;
			}
		}
		String []token5 = St5.split(" ");
        List<String> doc1 = Arrays.asList(token1);
        List<String> doc2 = Arrays.asList(token2);
        List<String> doc3 = Arrays.asList(token3);
        List<String> doc4 = Arrays.asList(token4);
        List<String> doc5 = Arrays.asList(token5);
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3, doc4, doc5);

        TFIDF calculator = new TFIDF();
        System.out.println("DOCUMENT - 1 :");
        int p = 0;
        String S1[] = new String[token1.length];
        for(int i = 0; i < token1.length; i++)
        {
        	double tfidf1 = calculator.tfIdf(doc1, documents, token1[i]);
            S1[i] = "TF-IDF of '"+token1[p]+"' in document 1 : " +tfidf1;
           	p++;
        }
        for(int i = 0; i < token1.length; i++)
        {
            int c = 0;
        	if(i==0)
        	{
        		System.out.println(S1[i]);
        	}
        	else
        	{
        		for(int j = 0; j < i; j++)
        		{
        			if(S1[i].equals(S1[j]))
        			{
        				c = 1;
        			}
        		}
        		if(c==0)
        		{
        			System.out.println(S1[i]);
        		}
        	}
        }

        System.out.println("\nDOCUMENT - 2 :");
        int q = 0;
        String S2[] = new String[token2.length];
        for(int i = 0; i < token2.length; i++)
        {
        	double tfidf2 = calculator.tfIdf(doc2, documents, token2[i]);
            S2[i] = "TF-IDF of '"+token2[q]+"' in document 2 : " +tfidf2;
           	q++;
        }
        for(int i = 0; i < token2.length; i++)
        {
            int c = 0;
        	if(i==0)
        	{
        		System.out.println(S2[i]);
        	}
        	else
        	{
        		for(int j = 0; j < i; j++)
        		{
        			if(S2[i].equals(S2[j]))
        			{
        				c = 1;
        			}
        		}
        		if(c==0)
        		{
        			System.out.println(S2[i]);
        		}
        	}
        }
        
        System.out.println("\nDOCUMENT - 3 :");
        int r = 0;
        String S3[] = new String[token3.length];
        for(int i = 0; i < token3.length; i++)
        {
        	double tfidf3 = calculator.tfIdf(doc3, documents, token3[i]);
            S3[i] = "TF-IDF of '"+token3[r]+"' in document 3 : " +tfidf3;
           	r++;
        }
        for(int i = 0; i < token3.length; i++)
        {
            int c = 0;
        	if(i==0)
        	{
        		System.out.println(S3[i]);
        	}
        	else
        	{
        		for(int j = 0; j < i; j++)
        		{
        			if(S3[i].equals(S3[j]))
        			{
        				c = 1;
        			}
        		}
        		if(c==0)
        		{
        			System.out.println(S3[i]);
        		}
        	}
        }
        
        System.out.println("\nDOCUMENT - 4 :");
        int s = 0;
        String S4[] = new String[token4.length];
        for(int i = 0; i < token4.length; i++)
        {
        	double tfidf4 = calculator.tfIdf(doc4, documents, token4[i]);
            S4[i] = "TF-IDF of '"+token4[s]+"' in document 4 : " +tfidf4;
           	s++;
        }
        for(int i = 0; i < token4.length; i++)
        {
            int c = 0;
        	if(i==0)
        	{
        		System.out.println(S4[i]);
        	}
        	else
        	{
        		for(int j = 0; j < i; j++)
        		{
        			if(S4[i].equals(S4[j]))
        			{
        				c = 1;
        			}
        		}
        		if(c==0)
        		{
        			System.out.println(S4[i]);
        		}
        	}
        }
        
        System.out.println("\nDOCUMENT - 5 :");
        int t = 0;
        String S5[] = new String[token5.length];
        for(int i = 0; i < token5.length; i++)
        {
        	double tfidf5 = calculator.tfIdf(doc5, documents, token5[i]);
            S5[i] = "TF-IDF of '"+token5[t]+"' in document 4 : " +tfidf5;
           	t++;
        }
        for(int i = 0; i < token5.length; i++)
        {
            int c = 0;
        	if(i==0)
        	{
        		System.out.println(S5[i]);
        	}
        	else
        	{
        		for(int j = 0; j < i; j++)
        		{
        			if(S5[i].equals(S5[j]))
        			{
        				c = 1;
        			}
        		}
        		if(c==0)
        		{
        			System.out.println(S5[i]);
        		}
        	}
        }
    }


}
