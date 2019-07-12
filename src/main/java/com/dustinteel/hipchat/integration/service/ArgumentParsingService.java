package com.dustinteel.hipchat.integration.service;

import org.springframework.stereotype.Service;

import static net.sourceforge.argparse4j.impl.Arguments.storeTrue;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

@Service
public class ArgumentParsingService {
	private ArgumentParser parser;
	
	public ArgumentParsingService () {
		ArgumentParser parser = ArgumentParsers
			.newFor("/cowsay")
			.build()
				.defaultHelp(true)
				.description("Allows you to get text formatted in the form of cowsay")
				.epilog("Cowsay");
		
			parser.addArgument("-f", "--fortune").help("Allows you to get a random fortune cookie and have it formatted in Cowsay format.")
				.action(storeTrue());
			parser.addArgument("-t", "--text").help("Provide text for the cow to say")
				.type(String.class)
				.metavar("TEXT");
			//TODO: Add these back in after getting the docker code merged.
//			parser.addArgument("-c", "--cow").help("Allows you to specify which cowfile is used when generating your cowsay.  Ignored if a mode is used.")
//				.type(String.class)
//				.metavar("COW");
//			parser.addArgument("-d", "--dead").help("Makes the cow appear dead.")
//				.action(storeTrue());
//			parser.addArgument("-e", "--eyes").help("Allows you to specify the appearance of the eyes using two characters.  If you do not use this argument, the default it 'oo'.  Ignored if a mode is used.")
//				.type(String.class)
//				.metavar("EYES");
//			parser.addArgument("-g", "--greedy").help("Activates greedy mode.")
//				.action(storeTrue());
//			parser.addArgument("-p", "--paranoia").help("Causes a state of paranoia to come over the cow")
//				.action(storeTrue());
//			parser.addArgument("-s", "--stoned").help("Makes the cow appear throughly stoned")
//				.action(storeTrue());
//			parser.addArgument("-t", "--tired").help("Yields a tired cow")
//				.action(storeTrue());
//			parser.addArgument("-w", "--wired").help("The opposite of -t")
//				.action(storeTrue());
//			parser.addArgument("-y", "--youth").help("Brings on the cow's youthful appearance")
//				.action(storeTrue());
//			parser.addArgument("-l", "--list").help("List all installed cowfiles")
//				.action(storeTrue());		
	}
	
	public Namespace parseArguments(String[] args) throws ArgumentParserException {
		return parser.parseArgs(args);
	}
	
	public String getHelp() {
		return parser.formatHelp();
	}
}
