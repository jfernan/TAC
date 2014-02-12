import java_cup.runtime.*;
%%

/*  Declaraciones */   
   
%cup 

%%   

/* Expresiones y reglas */
   
	"+"			{ return new Symbol(sym.MAS); }
	"-"                	{ return new Symbol(sym.MENOS); }
	"*"                	{ return new Symbol(sym.POR); }
    	"/"                	{ return new Symbol(sym.DIV); }
    	"("                	{ return new Symbol(sym.AP); }
    	")"                	{ return new Symbol(sym.CP); }
	"{"                	{ return new Symbol(sym.AL); }
	"}"                	{ return new Symbol(sym.CL); }
    	";"                	{ return new Symbol(sym.PYC); }
    	"="			{ return new Symbol(sym.ASIG); }
    	"++"			{ return new Symbol(sym.MASMAS); }
   	"if"			{ return new Symbol(sym.IF); }
   	"else"			{ return new Symbol(sym.ELSE); }
   	"do"			{ return new Symbol(sym.DO); }
	"while"			{ return new Symbol(sym.WHILE); }
	"for"			{ return new Symbol(sym.FOR); }
    	"print"			{ return new Symbol(sym.PRINT); }
    	"=="			{ return new Symbol(sym.EQUAL); }
    	"!="			{ return new Symbol(sym.NOTEQUAL); }
    	"<"			{ return new Symbol(sym.LT); }
    	"<="			{ return new Symbol(sym.LE); }
    	">"			{ return new Symbol(sym.GT); }
    	">="			{ return new Symbol(sym.GE); }
    	"!"             	{ return new Symbol(sym.NOT); }
    	"||"            	{ return new Symbol(sym.OR); }
    	"&&"            	{ return new Symbol(sym.AND); }
    	0|[1-9][0-9]*      	{ return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
    	[a-z][a-zA-Z0-9_-]*     { return new Symbol(sym.IDENT, yytext()); }
    	\r|\n              	{ }   
    	\ |\t|\f            	{ }  
    	[^]                	{ throw new Error("Illegal character <"+yytext()+">"); }
