package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;


public class ASCelestiaGefolge extends Eintrag {

	OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkTransport;

	boolean added = false;

	public ASCelestiaGefolge() {
		name = "Celestia-Gefolge\n3 Celestia, Schwester Dialogus, Schwester Hospitalis";
		grundkosten = 115;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("ASCelestiaGefolge", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASCelestiatrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Simulacrum Imperialis", 20));
		ogE.addElement(new OptionsGruppeEintrag("Heiliges Banner", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ASTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1x.setMaxAnzahl(3 - o1.getAnzahl());
        o1x.setAnzahl(0, 3 - o1.getAnzahl());
        
		int selectedSquads = BuildaHQ.getCountFromInformationVector("ASCelestiaGefolge");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("ASPrincipalis");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Gefolge > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("ASCelestiaGefolge", -1);
	}

}
