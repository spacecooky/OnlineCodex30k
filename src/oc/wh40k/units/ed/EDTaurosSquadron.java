package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class EDTaurosSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe1x;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;
    RuestkammerStarter rkTransport1;
    RuestkammerStarter rkTransport2;
    RuestkammerStarter rkTransport3;

	public EDTaurosSquadron() {
		name = "Tauros Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tauros", 1, 3, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

		seperator();

		add(oe1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Heavy Flamer", 3, 0));
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Tauros grenade launcher", 3, 5));

        seperator(5);

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 3, 10));
		add(oe3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Extra armour", 3, 15));
		add(oe4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Homing beacon", 3, 20));

        seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 5));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 10));

		seperator();

		rkTransport1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport1.initKammer(true);
		add(rkTransport1);

		seperator(5);

		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		seperator(5);

		rkTransport3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport3.initKammer(true);
		add(rkTransport3);

        complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
		oe1x.setMaxAnzahl(squad.getModelle());
		oe1x.setAnzahl(oe1x.getMaxAnzahl() - oe1.getAnzahl());
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setMaxAnzahl(squad.getModelle());
		oe4.setMaxAnzahl(squad.getModelle());

        o1.setPreis(squad.getModelle() * 5);
        o2.setPreis(squad.getModelle() * 10);

        rkTransport2.setAktiv(squad.getModelle() >= 2);
        rkTransport3.setAktiv(squad.getModelle() >= 3);
	}

}
