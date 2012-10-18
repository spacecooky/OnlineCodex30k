package oc.wh40k.units.el;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ELAsuryansJaeger extends Eintrag {

	AnzahlPanel AsuryansJaeger;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	RuestkammerStarter Serpent;

	public ELAsuryansJaeger() {
		name = "AsuryansJaeger";
		grundkosten = 0;

		add(AsuryansJaeger = new AnzahlPanel(ID, randAbstand, cnt, "Asuryans Jäger", 5, 10, 12));

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/ELAsuryansJaeger.jpg"));
		

		boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12);
		add(boss);

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("zwei Jagdkatapulte", 5));
		ogE.addElement(new OptionsGruppeEintrag("Asuryans Schw. & Pistole", "Asuryans Schwert und Pistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiew. & Schimmerfeld", "Energiewaffe und Schimmerfeld", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(15);

		add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Verteidigung", 15));
		add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shurikensturm", 15));

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
