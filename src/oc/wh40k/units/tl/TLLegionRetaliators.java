package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLLegionRetaliators extends Eintrag {

	AnzahlPanel marines;
	
	OptionsEinzelUpgrade sergeant;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter rkTransport;

	public TLLegionRetaliators() {
		name="Legion Retaliators\n";
		überschriftSetzen=true;
	
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionRetaliators.jpg"));
		

		marines = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
		add(marines);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator(10);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 20));
		
		seperator();
		
		add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran Sergeant", 25));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		sergeant.setSelected(true);
	}

}
