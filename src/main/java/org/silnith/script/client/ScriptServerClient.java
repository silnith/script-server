package org.silnith.script.client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.silnith.server.ScriptServer;
import org.silnith.server.ScriptServerHelper;

public class ScriptServerClient {
    
    public static void main(String[] args) throws InvalidName {
        final ORB orb = org.omg.CORBA_2_3.ORB.init(args, System.getProperties());
        
        final Object ref = orb.resolve_initial_references("script_server");
        final ScriptServer scriptServer = ScriptServerHelper.narrow(ref);
        scriptServer.executeScript("var foo = 0", null);
    }
    
}
