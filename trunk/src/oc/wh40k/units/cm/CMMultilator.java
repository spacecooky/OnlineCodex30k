package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMMultilator extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
	OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    
	public CMMultilator() {
		//name = "Multilator\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Multilator","Multilatoren", 1, 3, 55);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 8));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 6));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 6));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 4));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 5 * count);
		mal.setPreis("Mal des Tzeentch", 8 * count);
		mal.setPreis("Mal des Nurgle", 6 * count);
		mal.setPreis("Mal des Slaanesh", 6 * count);
		
		vdlk.setPreis("Veteranen des Langen Krieges", 4 * count);
	}
}
