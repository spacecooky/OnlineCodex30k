package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKSiegeVanguardIA10 extends BuildaVater {

	public VOLKSiegeVanguardIA10() {
		reflectionKennung = "SF";   // Ich dachte die Armee heißt Siege Assault Force
                                            // Hatte keine Lust alles wieder zu ändern
		reflectionKennungAllies = "SF";

		String[] HQeinträge = {"", "Siege Master", "Space Marine Ordensmeister", "Space Marine Captain", "Space Marine Scriptor", "Space Marine Ordenspriester", "Meister der Schmiede", "", "Ehrengarde", "Kommandotrupp", "", "Marneus Calgar", "Captain Cato Sicarius", "Scriptor-Magister Tigurius", "Ordenspriester Cassius", "Ordensmeister Pedro Kantor", "Captain Darnath Lysander", "Schatten-Captain Kayvaan Shrike", "Schmiedevater Vulkan He'stan", "Kor'sarro Khan", "", "[Forgeworld] Armenneus Valthex", "[Forgeworld] Chapter Master Lias Issodon", "[Forgeworld] Chapter Master Lugft Huron", /*"[Forgeworld] Damocles Rhino",*/ "[Forgeworld] Tyberos The Red Wake", "[Forgeworld] Vaylund Cal"};
		String[] Standardeinträge = {"", "Siege Dreadnought Talon", "Taktischer Trupp", "Siege Assault Squad"};
		String[] Eliteeinträge = {"", "Terminator-Trupp", "Terminator-Sturmtrupp", "Protektorgarde", "Ehrwürdiger Cybot", "Cybot", "Techmarine", "Servitoren"/*, "", "[Forgeworld] Chaplain Dreadnought", "[Forgeworld] Contemptor Mortis Pattern Dreadnought", "[Forgeworld] Contemptor Dreadnought", "[Forgeworld] Siege Dreadnought", "[Forgeworld] Land Raider Prometheus"*/};
		String[] Sturmeinträge = {"", "[IA Aeronautica] Caestus Assault Ram", "Sturmtrupp", "Expugnatorgarde", "Storm Eagle"/*, "", "[Forgeworld] Land Speeder Tempest Squadron", "[Forgeworld] Caestus Assault Ram"*/};
		String[] Unterstützungeinträge = {"", "Devastor-Trupp", "Salvenkanone", "Predator Tank Squadron", "Whirlwind Support Squadron", "Vindicator Tank Squadron", "Land Raider Achilles", "Land Raider Helios",
				"", "[IA Experimental] Spartan Assault Tank", "[IA Experimental] RapierCarrierBattery",            
		/*"", "[Forgeworld] Deathstorm Drop Pod", "[Forgeworld] Whirlwind Hyperios", "[Forgeworld] Land Raider Achilles", "[Forgeworld] Land Raider Helios", "[Forgeworld] Tarantula-Batterie"*/};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};

//		String[] ApoEinheiten = {"", "Land Raider Terminus Ultra",
//                    "" ,"Thunderhawk-Landungsschiff",
//                    "", "[Forgeworld] Thunderhawk Transporter"
//                    };
//                String[] ApoFormationen = {"", "Gepanzerte Speerspitze"};

		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 2, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 3, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(reflectionKennung, cnt, 0, 6, Befestigungen));
		/*if(oc.OnlineCodex.getInstance().isApo()) {
                    cnt += CHOOSERGRUPPEN_X_ABSTAND;
                    adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
                    cnt += CHOOSERGRUPPEN_X_ABSTAND;
                    adden(new ChooserGruppe(reflectionKennung, cnt, 0, 8, ApoFormationen));
                }*/
		cnt += 480;

		nameDerArtDerArmee = "Space Marines";
		nameDerArtDerArmeeDekliniert = "Space Marines";
		textAreaUeberschrift = "Space Marines Armee";

		noAllies.clear();
		noAllies.add("CD");
		noAllies.add("CM");
		noAllies.add("RH");
		noAllies.add("SF");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}