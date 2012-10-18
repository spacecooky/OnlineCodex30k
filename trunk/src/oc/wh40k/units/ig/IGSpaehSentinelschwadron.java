package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IGSpaehSentinelschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;

	private boolean isDemonHunters = false;
	private boolean isWitchHunters = false;
	public IGSpaehSentinelschwadron() {
		name = "Späh-Sentinelschwadron";
		grundkosten = 0;

		checkDraftOption();
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Spähsentinel", "Spähsentinels", 1, 3, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGScoutSentinelSquadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Suchscheinwerfer", 3, 1));
		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Suchkopfrakete", 3, 10));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Nebelwerfer", 0));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnnetze", 0));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle());
    o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

		oe1.setMaxAnzahl(squad.getModelle());
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setPreis(squad.getModelle() * 5);
		oe4.setPreis(squad.getModelle() * 10);

		// Check validity in case of drafted units for Inquisition amries
		if(isDemonHunters || isWitchHunters) {
			int draftTroops = BuildaHQ.getCountFromInformationVector( isDemonHunters ? "DJDraftTroops" : "HXDraftTroops" );
			int choice = BuildaHQ.getCountFromInformationVector("IGScoutSentinelSquadron");
			if(draftTroops < 2) {
				setFehlermeldung("Zu wenig IA-Standards!");
			}
			else {
				if(choice > 1 && isDemonHunters) {
					setFehlermeldung("0-1 Auswahl");
				} else {
					setFehlermeldung("");
				}
			}
		}
	}

	private void checkDraftOption() {
		isDemonHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Daemonenjaeger");
		isWitchHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Hexenjaeger");

		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGScoutSentinelSquadron", 1);
		}
	}

	@Override
	public void deleteYourself() {
		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGScoutSentinelSquadron", -1);
		}
		super.deleteYourself();
	}

}
