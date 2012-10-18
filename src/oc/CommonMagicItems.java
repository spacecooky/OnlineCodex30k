package oc;

import java.util.Collections;
import java.util.Vector;

public class CommonMagicItems extends BuildaPanel {
	
	@SuppressWarnings("unchecked")
	public static void addCommonWeapons( Vector ogE, int maxCosts, int behaende, int schlachten, int sdm, int reissende ) {	
		if ( maxCosts >= 60 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenklinge"), 60));
		if ( maxCosts >= 60 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert des Blutbades"), 60));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Obsidianklinge"), 50));
		if ( maxCosts >= 40 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerklinge"), 40));
		if ( maxCosts >= 40 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert des Haders"), 40));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Duellklingen"), 35));
		if ( maxCosts >= 30 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heldentöter"), 30));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberraubklinge"), 25));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert des Todes"),BuildaHQ.translate("Schwert des schnellen Todes"), 25));
		if ( maxCosts >= 20 && !reflectionKennung.equals("CK"))  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Berserkerschwert"), 20));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goldenes Siegelschwert"), 15));
		if(  maxCosts >= behaende && behaende != 0 )ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Behände Klinge"), behaende));
		if(  maxCosts >= schlachten && schlachten != 0 )ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlachtenklinge"), schlachten));
		if(  maxCosts >= sdm && sdm != 0 )ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Macht"), sdm));
		if(  maxCosts >= reissende && reissende != 0 )ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Reißende Klinge"), reissende));
		if ( maxCosts >= 10 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Reliquienschwert"), 10));
		if ( maxCosts >= 10 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kreischende Klinge"), 10));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Pein"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kriegerfluch"), 5));
		
		Collections.sort(ogE);
	}
	
	@SuppressWarnings("unchecked")
	public static void addCommonArcane( Vector ogE, int maxCosts, int staff, int stone, int scroll ) {	
		if ( maxCosts >= 70 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch von Ashur"), 70));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rolle der Rückkopplung"), 50));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rolle des Energieraubs"), 50));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sivejir's Fluchrolle"), 50));
		if ( maxCosts >= staff &&  staff != 0 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Zauberei"), staff));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiespruchrolle"), 35));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pechkohlen-Zauberstab"), 35));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verbotener Stab"), 35));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gauners Scherbe"), 25));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Erdender Stab"), 25));
		if ( maxCosts >=  scroll && scroll != 0 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Magiebannende Rolle"), scroll));
		if ( maxCosts >= stone && stone != 0 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestein"), stone));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zepter der Stabilität"), 15));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kanalisierungsstab"), 15));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rolle des Schutzes"), 15));
		
		Collections.sort(ogE);
	}
	
	@SuppressWarnings("unchecked")
	public static void addCommonArmour( Vector ogE, int maxCosts, int enchshield ) {	
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Schicksals"), 50));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schurkenhelm"), 50));
		if ( maxCosts >= 45 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Silberstahlrüstung"), 45));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Glücks"), 35));
		if ( maxCosts >= 30 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm der Zwietracht"), 30));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schuppenrüstung"), 25));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild des Ptolos"), 25));
		if ( maxCosts >= 20 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberspruch-Schild"), 20));
		if ( maxCosts >= 20 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Glücksritters"), 20));
		if ( maxCosts >= enchshield && enchshield != 0 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verzauberter Schild"), enchshield));
		if ( maxCosts >= 10 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenhelm"), 10));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Glückbringender Schild"), 5));
		
		Collections.sort(ogE);
	}
	
	@SuppressWarnings("unchecked")
	public static void addCommonEnchanted( Vector ogE, int maxCosts ) {	
		if ( maxCosts >= 100 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberhut"), 100));
		if ( maxCosts >= 100 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Faltbare Festung"), 100));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Arabianischer Teppich"), 50));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Krone der Herrschaft"), 35));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heiltrank"), 35));
		if ( maxCosts >= 35 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flügelfluchreif"), 35));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rubinring der Zerstörung"), 25));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schreckensmaske von Iek!"), 25));
		if ( maxCosts >= 20 && !reflectionKennung.equals("DE"))  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stärketrank"), 20));
		if ( maxCosts >= 20 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Widerstandstrank"), 20));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Des anderen Gauners Scherbe"), 15));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfluch Ikone"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Trank der Tollkühnheit"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Trank der Geschwindigkeit"), 5));
		
		Collections.sort(ogE);
	}
	
	@SuppressWarnings("unchecked")
	public static void addCommonBanner( Vector ogE, int maxCosts, int warbanner ) {	
		if ( maxCosts >= 55 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Mordlust"), 55));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heulendes Banner"), 50));
		if ( maxCosts >= 50 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Waldläuferbanner"), 50));
		if ( maxCosts >= 45 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klingenstandarte"), 45));
		if ( maxCosts >= warbanner && warbanner != 0 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kriegsbanner"), warbanner));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Eile"), 15));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Knochenstandarte"), 15));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Disziplin"), 15));
		if ( maxCosts >= 10 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Ewigen Flamme"), 10));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Strahlende Flagge"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Vogelscheuchenbanner"), 5));
		
		Collections.sort(ogE);
	}
	
	@SuppressWarnings("unchecked")
	public static void addCommonTalismans( Vector ogE, int maxCosts, int protection ) {	
		if ( maxCosts >= 45 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Talisman der Bewahrung"), 45));
		if ( maxCosts >= 45 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Großer Obsidian"), 45));
		if ( maxCosts >= 30 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Talisman der Ausdauer"), 30));
		if ( maxCosts >= 30 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Obsidianamulett"), 30));
		if ( maxCosts >= 25 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dämmerstein"), 25));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Opalamulett"), 15));
		if ( maxCosts >= 15 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Obsidiananhänger"), 15));
		if( maxCosts >= protection && protection != 0 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schutztalisman"), protection));
		if ( maxCosts >= 10 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Samen der Wiedergeburt"), 10));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenfluchstein"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Federrupfanhänger"), 5));
		if ( maxCosts >= 5 )  ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Glücksstein"), 5));
		
		Collections.sort(ogE);
	}
}
