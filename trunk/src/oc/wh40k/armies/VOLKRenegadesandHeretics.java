package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKRenegadesandHeretics extends BuildaVater {

	public VOLKRenegadesandHeretics() {
		reflectionKennung = "RH";
		reflectionKennungAllies = "RH";

		String[] HQeinträge = {"", "Company Command Platoon", "Enforcer", "Rogue Psyker", "Apostate Preacher"};
		String[] Eliteeinträge = {"", "Disciples of Xaphan", "Renegade Ogryn Berserkers", "Alpha Legion Squad"};
		String[] Standardeinträge = {"", "Renegade Militia Platoon", "Workers Rabble", "Renegade Armoured Fist Squad"};
		String[] Sturmeinträge = {"", "Hellhound", "Scout Sentinel Squadron", "Armoured Sentinel Squadron", "Salamander Scout Squadron"};
		String[] Unterstützungeinträge = {"", "Renegade Militia Heavy Weapon Platoon", "Sentry Gun Battery", "Turret Emplacement", "Renegade Tank", "Close Support Artillery", "Weapon Platform", "Mine Field", "Artillery Strike"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
        
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
		cnt += CHOOSERGRUPPEN_X_ABSTAND;

		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = "Renegades and Heretics";
		nameDerArtDerArmeeDekliniert = "Renegades and Heretics";
		textAreaUeberschrift = "Renegades and Heretics";

		noAllies.clear();
		noAllies.add("AS");
		noAllies.add("BA");
		noAllies.add("BT");
		noAllies.add("DA");
		noAllies.add("DE");
		noAllies.add("DK");
		noAllies.add("DM");
		noAllies.add("ED");
		noAllies.add("RH");
		noAllies.add("SF");
		noAllies.add("SM");
		noAllies.add("SW");
		noAllies.add("TL");
		noAllies.add("TY");
		
		complete();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}