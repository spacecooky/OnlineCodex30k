package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BASturmtrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe oe1;
	OptionsEinzelUpgrade jet;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public BASturmtrupp() {
		name = "Sturmtrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 18);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BASturmtrupp.jpg"));

		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 0));
		jet.setSelected(true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		add(oe1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BAStormSarge", "Upgrade zum Sergeant");
		rkBoss.initKammer(false);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		int maxSelect = new Double(Math.floor(squad.getModelle() / 5)).intValue();
		o1.setMaxAnzahl(maxSelect);
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - 1);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - 1);

        oe1.setMaxAnzahl(squad.getModelle() - 1);
        oe1.setAnzahl(0, squad.getModelle() - 1);
		
		rkTransport.setAktiv(!jet.isSelected());

		if(jet.isSelected()) {
			ico.setIcon("oc/wh40k/images/BASturmtrupp.jpg");
		} else {
			ico.setIcon("oc/wh40k/images/BASturmtruppOhneJetpack.jpg");
		}
        
        jet.setLegal(jet.isSelected() || rkTransport.isSelected());
        rkTransport.setLegal(jet.isSelected() || rkTransport.isSelected());
	}

}
