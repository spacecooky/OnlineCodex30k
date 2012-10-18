package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DKGrenadierSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
    RuestkammerStarter rkTransport;

	public DKGrenadierSquad() {
		name = "Death Korps Grenadier Squad";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Grenadiers", 5, 10, 18);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber-team", "Weapon team with Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer-team", "Weapon team with Heavy flamer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Demolition charge", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox Caster", 5));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade to Watchmaster", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);

        int selectedGrenadiers = o1.getAnzahl() * 2 + o2.getAnzahl() + o3.getAnzahl() + oe2.getSelectedAsInt();

        o2.setMaxAnzahl(squad.getModelle() - 1 - selectedGrenadiers + o2.getAnzahl() >= 2 ? 2 : squad.getModelle() - 1 - selectedGrenadiers + o2.getAnzahl());

        o1.setAktiv(selectedGrenadiers + 2 <= squad.getModelle() -1 + o1.getAnzahl() * 2);
        o2.setAktiv(selectedGrenadiers + 1 <= squad.getModelle() - 1+ o2.getAnzahl());
        o3.setAktiv(selectedGrenadiers + 1 <= squad.getModelle() - 1 + o3.getAnzahl());
        oe2.setAktiv(selectedGrenadiers + 1 <= squad.getModelle() - 1+ oe2.getSelectedAsInt());

        rkTransport.setAktiv(squad.getModelle() <= 5);
	}

}
