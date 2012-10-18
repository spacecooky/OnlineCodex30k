package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BAExpugnatorgarde extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade jet;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public BAExpugnatorgarde() {
		name = "Expugnatorgarde\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Veteranen", 5, 10, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BAExpugnatorgarde.jpg"));

		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BAStormSarge", "Upgrade zum Sergeant");
		rkBoss.initKammer(true);
		rkBoss.setGrundkosten(15);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		jet.setPreis(squad.getModelle() * 10);

		o1.setMaxAnzahl((squad.getModelle() * 2) - 2); // not for sergeant
		o2.setMaxAnzahl(squad.getModelle() - 1); // not for sergeant
		
		rkTransport.setAktiv(!jet.isSelected());

		rkTransport.getPanel().setLocation(
			(int) rkTransport.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}

}
