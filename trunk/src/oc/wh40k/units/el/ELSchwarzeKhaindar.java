package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ELSchwarzeKhaindar extends Eintrag {

	AnzahlPanel SchwarzeKhaindar;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	RuestkammerStarter Serpent;

	public ELSchwarzeKhaindar() {

		name = "SchwarzeKhaindar";

		grundkosten = 0;



		SchwarzeKhaindar = new AnzahlPanel(ID, randAbstand, cnt, "Schwarze Khaindar", 3, 5, 35);

		add(SchwarzeKhaindar);

		seperator();





		add(ico = new oc.Picture("oc/wh40k/images/SchwarzeKhaindar.gif"));





		boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12);

		add(boss);

		seperator(5);



		ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 0));

		ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 10));

		ogE.addElement(new OptionsGruppeEintrag("Orkan-Raketenwerfer", 20));



		o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);

		add(o1);

		seperator(15);





		o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Feuerhagel", 20);

		add(o4);



		o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scharfschütze", 10);

		add(o5);

		seperator();



		Serpent = new RuestkammerStarter(ID, randAbstand, cnt, "ELSerpentKammer", "Serpent");

		Serpent.initKammer();

		add(Serpent);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		if (boss.isSelected()) {

			o1.setAktiv(true);

			o4.setAktiv(true);

			o5.setAktiv(true);
		} else {

			o1.setAktiv(false);

			o4.setAktiv(false);

			o5.setAktiv(false);
		}



	}
}
