/* Regeln aus Imperial Armour Volume Five
 * aktualisierte Version zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/k/kreig.pdf
 */

package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDeathKorpsofKrieg extends BuildaVater {

	public VOLKDeathKorpsofKrieg() {
		reflectionKennung = "DK";
		reflectionKennungAllies = "DK";

		String[] HQeinträge = {"", "Company Command Squad", "Commissar-General", "Quartermaster", "Death Rider Command Squad"};
		String[] Eliteeinträge = {"", "Grenadier Squad", "Heavy Mortar Battery", "Heavy Quad Launcher Battery", "", "[Forgeworld] Rapier Carrier with Laser Destroyer"};
		String[] Standardeinträge = {"", "Infantry Platoon", "Engineer Squad"};
		String[] Sturmeinträge = {"", "Hellhound Squadron", "Death Rider Squadron", "Cyclops Demolition Squadron"};
		String[] Unterstützungeinträge = {"", "Leman Russ Squadron", "Thunderer Siege Tank Squadron", "Ordnance Battery", "Bombard Battery", "Heavy Weapons Platoon"};
		String[] Befestigungen = {"", "Aegis-Verteidigungslinie", "Himmelsschild-Landeplattform", "Imperiale Bastion", "Festung der Erlösung"};
		String[] ApoEinheiten = {"","Super Heavy Tank Squadron","Macharius Squadron","Gorgon Squadron","Malcador Squadron","Minotaur Battery","Valdor Battery","Marauder Squadron","Warhound Titan Squadron","Reaver Titan Maniple"};

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
		cnt += 480;
		
		if(oc.OnlineCodex.getInstance().isApo()) adden(new ChooserGruppe(reflectionKennung, cnt, 0, 7, ApoEinheiten));
		if(oc.OnlineCodex.getInstance().isApo()) cnt += CHOOSERGRUPPEN_X_ABSTAND;

		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = "Death Korps of Krieg";
		nameDerArtDerArmeeDekliniert = "Death Korps of Krieg";
		textAreaUeberschrift = "Death Korps of Krieg";

		noAllies.clear();
		noAllies.add("DK");
		noAllies.add("TY");
		
		complete();
	}

	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}
