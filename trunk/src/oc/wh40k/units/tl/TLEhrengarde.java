package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLEhrengarde extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public TLEhrengarde() {
		name = "Ehrengarde\n";
		grundkosten = 0;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("TLHonourGuard", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ehrengardisten", 3, 10, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMEhrengarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Auxilaris-Granatwerfer", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ordensbanner", 25));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TLOrdenschampion", "Upgrade zum Ordenschampion");
		rkBoss.initKammer(true, true, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());

		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLHonourGuard");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Ehrengarde > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLHonourGuard", -1);
		super.deleteYourself();
	}
	
}
