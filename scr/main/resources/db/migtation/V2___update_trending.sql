CREATE OR REPLACE FUNCTION update_trending() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.comments_count > 3 THEN
        NEW.trending := TRUE;
    ELSE
        NEW.trending := FALSE;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_trending
BEFORE UPDATE ON articles
FOR EACH ROW
EXECUTE FUNCTION update_trending();
